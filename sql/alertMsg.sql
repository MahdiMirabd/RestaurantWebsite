DROP TABLE IF EXISTS messagesTable CASCADE ;

CREATE TABLE messagesTable ( id SERIAL PRIMARY KEY , message VARCHAR (225) NOT NULL , readFlag VARCHAR (50) NOT NULL );

select id,message,readFlag from messagesTable where readFlag = false ;