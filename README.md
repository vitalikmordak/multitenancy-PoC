# multitenancy-PoC
## Goal
Multitenancy support with a shared DB and schema.

## TODO
1. Need to add docker-compose with postgreSQL
2. Need to create entities, repos, service
3. Add Hibernate filters
4. Create custom annotation to mark query as tenancy and implement AOP to enable a filter for specified query.

## Need to check
1. Whether adding a filter to the request will work if the annotation is in the repository on the method.
2. Check if it will be worked with a complicated query which exists joins.
