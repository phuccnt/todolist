CREATE TABLE if not exists todo_list (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) not null,
                           description VARCHAR(255),
                           created_date TIMESTAMP
);

CREATE TABLE if not exists todo_task (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) not null,
                           is_completed BOOLEAN,
                           created_date TIMESTAMP,
                           todo_list_id BIGINT,
                           CONSTRAINT fk_todo_list
                           FOREIGN KEY (todo_list_id)
                           REFERENCES todo_list(id)
);

INSERT INTO todo_list (name, description, created_date)
VALUES ('Shopping List', 'List of items to buy', CURRENT_TIMESTAMP);

INSERT INTO todo_list (name, description, created_date)
VALUES ('Work Tasks', 'Tasks for the work project', CURRENT_TIMESTAMP);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Buy groceries', false, CURRENT_TIMESTAMP, 1);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Pick up dry cleaning', true, CURRENT_TIMESTAMP, 1);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Prepare presentation', false, CURRENT_TIMESTAMP, 2);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Send report to manager', false, CURRENT_TIMESTAMP, 2);
