CREATE TABLE IF NOT EXISTS movie (
    id          bigint primary key AUTO_INCREMENT,
    title       varchar(255) not null,
    imgURL     varchar(255) not null,
    year        int unsigned not null,
    director    varchar(255) not null
);

CREATE TABLE IF NOT EXISTS reviewer (
    id          bigint primary key AUTO_INCREMENT,
    name        varchar(255) not null
);

CREATE TABLE IF NOT EXISTS rating (
    id          bigint primary key AUTO_INCREMENT,
    movieId     bigint not null,
    reviewerId  bigint not null,
    star       int unsigned not null,
    ratingDate date not null,
    foreign key (movieId) references movie(id)
);