--liquibase formatted sql
--changeset jvm:1
alter table user_details add age int unsigned default null;