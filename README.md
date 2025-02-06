#### Created by following the Masterclass here :
https://www.youtube.com/watch?v=YRqS_R4wBn0

### Database Configuration

This application requires a PostgreSQL database. Before running the project, make sure you have PostgreSQL installed and create a superuser with the following credentials:

User: postgres

Password: postgres


#### Steps to Set Up PostgreSQL:

1. Open a terminal and log in to PostgreSQL:
   ```sh
   psql -U postgres

2. If needed, set or change the password for the postgres user:
 ```sql
ALTER USER postgres PASSWORD 'postgres';
```

3. Create the required database:
 ```sql
psql -U postgres -d todo;
```

If you want to use a different username or password, update the Configs class accordingly.