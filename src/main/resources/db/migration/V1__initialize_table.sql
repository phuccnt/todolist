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
VALUES ('Shopping List', 'List of items to buy', '2023-01-05 11:46:41');

INSERT INTO todo_list (name, description, created_date)
VALUES ('Work Tasks', 'Tasks for the work project', CURRENT_TIMESTAMP);

INSERT INTO todo_list (name, description, created_date)
VALUES ('Personal Tasks', 'Tasks for personal errands', '2023-02-15 09:30:00');

INSERT INTO todo_list (name, description, created_date)
VALUES ('Home Improvement', 'Tasks for home renovation', '2023-03-20 14:15:00');

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Buy groceries', false, CURRENT_TIMESTAMP, 1);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Pick up dry cleaning', true, CURRENT_TIMESTAMP, 1);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Prepare presentation', false, CURRENT_TIMESTAMP, 2);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Send report to manager', false, CURRENT_TIMESTAMP, 2);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Pay bills', false, '2023-02-15 10:00:00', 3);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Book flight tickets', false, '2023-02-16 16:45:00', 3);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Paint the living room', false, '2023-03-22 11:30:00', 4);

INSERT INTO todo_task (name, is_completed, created_date, todo_list_id)
VALUES ('Install new light fixtures', false, '2023-03-25 09:00:00', 4);