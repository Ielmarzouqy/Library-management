create table librarean (
id int auto_increament primary key,
name varchar(255)
);

create table author(
    id int auto_increament primary key,
    name varchar(255)
);

create table member (
     id int auto_increament primary key,
     name varchar(255)
     );

 create table collection(
     id int auto_increament primary key,
     title varchar(255),
     quantity int,
     author int,
     constraint fk_author foreign key (author)
     references author(id)
 );

 create table book(
    id int auto_increament primary key,
    price float,
    available booleain,
    islost booleain,
    isbn int,
    constraint fk_collection foreign key(isbn)
    references collection(id)
 );

 create table borrowbook(
    id int auto_increament primary key,
    borrowedbook int,
    constraint fk_borrowedbook foreign key (borrowedbook)
    references book(id),
    memberid int,
    constraint fk_memberid foreign key (memberid)
    references member(id)
    dateStart date,
    dateEnd date,
 );

 create trigger update_collection_quantity
 after insert on book
 for each row
 begin

 update collection
 set quantity = quantity+1
 where id = new.isbn;
 end;
