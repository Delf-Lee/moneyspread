insert into user (x_user_id) values (111);
insert into user (x_user_id) values (222);
insert into user (x_user_id) values (333);
insert into user (x_user_id) values (444);
insert into user (x_user_id) values (555);

insert into chat_room (x_room_id) values (11);
insert into chat_room (x_room_id) values (22);
insert into chat_room (x_room_id) values (33);

insert into user_in_chat_room (chatroom_id, user_id) values (1,1);
insert into user_in_chat_room (chatroom_id, user_id) values (1,2);
insert into user_in_chat_room (chatroom_id, user_id) values (1,3);
insert into user_in_chat_room (chatroom_id, user_id) values (2,3);
insert into user_in_chat_room (chatroom_id, user_id) values (2,4);
insert into user_in_chat_room (chatroom_id, user_id) values (3,1);
insert into user_in_chat_room (chatroom_id, user_id) values (3,3);

insert into spread (token, amount, people) values ('aaa', 10000, 5);

insert into user_getting_money(spread_id, user_id, money) values (1, 1, 5000);
insert into user_getting_money(spread_id, user_id, money) values (1, 2, 3000);