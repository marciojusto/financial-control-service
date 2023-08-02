FROM postgres:14.1-alpine
LABEL authors="marcio_oliveira"

RUN apk add --no-cache postgresql-contrib

# Install uuid-ossp extension
RUN echo "CREATE EXTENSION IF NOT EXISTS \"uuid-ossp\";" > /docker-entrypoint-initdb.d/uuid-ossp.sql
