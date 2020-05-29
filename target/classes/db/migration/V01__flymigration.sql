create table products(
    product_id int auto_increment,
    product_name varchar(255) not null,
    constraint product_pk primary key (product_id)
);

create table reviews(
    review_id int not null auto_increment,
    product_id int not null,
    review_title varchar(1000) not null,
    constraint review_pk primary key (review_id),
    constraint product_review_fk foreign key (product_id) references products (product_id);
);

create table comments(
    comment_id int not null auto_increment,
    review_id int,
    comment_text varchar(1000) not null,
    constraint comment_pk primary key (comment_id),
    constraint review_comment_fk foreign key (review_id) references reviews (review_id);
);
