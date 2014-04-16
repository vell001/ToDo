-- sqlite3

-- Thing

drop table if exists "main"."Thing";
create table "Thing" (
"id" integer not null primary key autoincrement,
"message" text not null, 
"time" text not null,
"systemMessage" text,
"status" integer not null default 0
);

-- Setting

drop table if exists "main"."Setting";

create table Setting(
"id" integer not null primary key autoincrement,
"sleepTime" integer not null default 120
);