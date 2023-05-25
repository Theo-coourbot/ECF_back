CREATE TABLE `activity` (
                            `id_cours` int NOT NULL,
                            `date_session` date DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `center_id` int DEFAULT NULL,
                            PRIMARY KEY (`id_cours`),
                            KEY `FKm3vd2lp0r5v0lwdyi8e3cnhq9` (`center_id`),
                            CONSTRAINT `FKm3vd2lp0r5v0lwdyi8e3cnhq9` FOREIGN KEY (`center_id`) REFERENCES `center` (`center_id`)
)


CREATE TABLE `adhering` (
                            `id_adhering` int NOT NULL,
                            `age` int NOT NULL,
                            `firstName` varchar(255) DEFAULT NULL,
                            `lastName` varchar(255) DEFAULT NULL,
                            `center_id` int DEFAULT NULL,
                            PRIMARY KEY (`id_adhering`),
                            KEY `FKmuc51ene6cquwmvb1a8kd1d0p` (`center_id`),
                            CONSTRAINT `FKmuc51ene6cquwmvb1a8kd1d0p` FOREIGN KEY (`center_id`) REFERENCES `center` (`center_id`)
)


CREATE TABLE `adhering_activity` (
                                     `adhering_id` int NOT NULL,
                                     `activity_id` int NOT NULL,
                                     KEY `FKqe3tyndfm7ucyoke4pl00nb5u` (`activity_id`),
                                     KEY `FKd697yxaj4i2ews7j8bx1ikted` (`adhering_id`),
                                     CONSTRAINT `FKd697yxaj4i2ews7j8bx1ikted` FOREIGN KEY (`adhering_id`) REFERENCES `adhering` (`id_adhering`),
                                     CONSTRAINT `FKqe3tyndfm7ucyoke4pl00nb5u` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`id_cours`)
)



CREATE TABLE `center` (
                          `center_id` int NOT NULL,
                          `adress` varchar(255) DEFAULT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`center_id`)
)