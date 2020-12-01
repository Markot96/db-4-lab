CREATE SCHEMA IF NOT EXISTS `topolevsky`;
USE `topolevsky`;

DROP TABLE IF EXISTS `topolevsky`.`password`;
DROP TABLE IF EXISTS `topolevsky`.`story`;
DROP TABLE IF EXISTS `topolevsky`.`story_line`;
DROP TABLE IF EXISTS `topolevsky`.`user`;
DROP TABLE IF EXISTS `topolevsky`.`reactions`;
DROP TABLE IF EXISTS `topolevsky`.`comments`;

CREATE TABLE IF NOT EXISTS `topolevsky`.`user`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `nickname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `topolevsky`.`story_line`
(
    `user_id`        INT         NOT NULL AUTO_INCREMENT,
    `story_author`   VARCHAR(45) NOT NULL,
    `watched_status` INT     NOT NULL,
    INDEX `fk_story_line_user1_idx` (`user_id` ASC) VISIBLE,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_story_line_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `topolevsky`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `topolevsky`.`comments`
(
    `id`              INT         NOT NULL AUTO_INCREMENT,
    `author`          VARCHAR(45) NOT NULL,
    `text`            VARCHAR(45) NOT NULL,
    `amount_of_likes` INT         NOT NULL,
    `writing_time`    VARCHAR(45)        NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `topolevsky`.`reactions`
(
    `id`               INT NOT NULL AUTO_INCREMENT,
    `amount_of_views`  INT NOT NULL,
    `amount_of_emojis` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `topolevsky`.`story`
(
    `id`                  INT         NOT NULL AUTO_INCREMENT,
    `type_of_story`       INT     NOT NULL,
    `file_name`           VARCHAR(45) NOT NULL,
    `upload_time`         VARCHAR(45)        NOT NULL,
    `file_size_in_mb`     FLOAT       NOT NULL,
    `duration_in_seconds` INT         NULL,
    `story_line_user_id`  INT         NOT NULL,
    `comments_id`         INT         NOT NULL,
    `reactions_id`        INT         NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    INDEX `fk_story_story_line1_idx` (`story_line_user_id` ASC) VISIBLE,
    INDEX `fk_story_comments1_idx` (`comments_id` ASC) VISIBLE,
    INDEX `fk_story_reactions1_idx` (`reactions_id` ASC) VISIBLE,
    CONSTRAINT `fk_story_story_line1`
        FOREIGN KEY (`story_line_user_id`)
            REFERENCES `topolevsky`.`story_line` (`user_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_story_comments1`
        FOREIGN KEY (`comments_id`)
            REFERENCES `topolevsky`.`comments` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_story_reactions1`
        FOREIGN KEY (`reactions_id`)
            REFERENCES `topolevsky`.`reactions` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `topolevsky`.`password`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `password` VARCHAR(45) NOT NULL,
    `user_id`  INT         NOT NULL,
    PRIMARY KEY (`id`, `user_id`),
    INDEX `fk_password_user1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `fk_password_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `topolevsky`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

INSERT INTO `topolevsky`.`user` (`nickname`)
VALUES ('andriy'),
       ('bohdan'),
       ('connor'),
       ('david'),
       ('eugene'),
       ('florence'),
       ('george'),
       ('halyna'),
       ('ivan'),
       ('jean');

INSERT INTO `topolevsky`.`story_line` (`story_author`, `watched_status`)
VALUES ('andriy', '1'),
       ('bohdan', '0'),
       ('connor', '0'),
       ('david', '1'),
       ('eugene', '0'),
       ('florence', '0'),
       ('george', '0'),
       ('halyna', '0'),
       ('ivan', '0'),
       ('jean', '1');

INSERT INTO `topolevsky`.`comments` (`author`, `text`, `amount_of_likes`, `writing_time`)
VALUES ('andriy', 'wow', '6', '10:22'),
       ('bohdan', 'great', '9', '11:12'),
       ('connor', 'super', '10', '12:11'),
       ('david', 'wtf?', '0', '12:54'),
       ('eugene', 'seriously???', '10', '13:45'),
       ('florence', 'im shocked', '10', '15:57'),
       ('george', 'bruh', '0', '16:35'),
       ('halyna', 'ok', '0', '18:27'),
       ('ivan', 'let it be', '7', '21:00'),
       ('jean', 'it was me', '4', '21:15');

INSERT INTO `topolevsky`.`reactions` (`amount_of_views`, `amount_of_emojis`)
VALUES ('82', '0'),
       ('69', '5'),
       ('55', '2'),
       ('66', '20'),
       ('60', '9'),
       ('55', '0'),
       ('47', '19'),
       ('83', '3'),
       ('76', '4'),
       ('79', '14');


INSERT INTO `topolevsky`.`story` (`type_of_story`, `file_name`, `upload_time`, `file_size_in_mb`, `duration_in_seconds`,
                                  `story_line_user_id`, `comments_id`, `reactions_id`)
VALUES ('0', 'story1', '10:11', '46', null, '1', '1', '1'),
       ('0', 'story2', '10:25', '100', null, '2', '2', '2'),
       ('0', 'story3', '12:25', '80', null, '3', '3', '3'),
       ('1', 'story4', '13:28', '58', '11', '4', '4', '4'),
       ('0', 'story5', '13:54', '12', null, '5', '5', '5'),
       ('1', 'story6', '14:35', '83', '7', '6', '6', '6'),
       ('0', 'story7', '17:31', '43', null, '7', '7', '7'),
       ('1', 'story8', '20:25', '50', '13', '8', '8', '8'),
       ('0', 'story9', '20:40', '40', null, '9', '9', '9'),
       ('1', 'story10', '21:56', '63', '14', '10', '10', '10');

INSERT INTO `topolevsky`.`password` (`password`, `user_id`)
VALUES ('password1', '1'),
       ('password2', '2'),
       ('password3', '3'),
       ('password4', '4'),
       ('password5', '5'),
       ('password6', '6'),
       ('password7', '7'),
       ('password8', '8'),
       ('password9', '9'),
       ('password10', '10');
    