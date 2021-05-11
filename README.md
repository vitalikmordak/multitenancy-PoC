# multitenancy-PoC
## Goal
Multitenancy support with a shared DB and schema.

## TODO
1. ~~Need to add docker-compose with postgreSQL~~
2. ~~Need to create entities, repos, service~~
3. ~~Add Hibernate filters~~
4. ~~Create custom annotation to mark query as tenancy and implement AOP to enable a filter for specified query.~~

## Need to check
1. Whether adding a filter to the request will work if the annotation is in the repository on the method.
2. Check if it will be worked with a complicated query which exists joins.

## Results
If a repository uses a method that starts with find..() then a filter will not work because EntityManager will use the find method, 
and filters apply only for queries. For more information see [here](https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#pc-filter) 

If we want to use find we should override the query with `@Query()` and use JPQL. A Native query will not work with Hibernate filters.

When we use joins and want to apply filters for join query we need to add @Filter annotation for a field, like the following:
```java
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
	private List<Comment> comments = new ArrayList<>();
```
