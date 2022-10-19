CREATE TABLE IF NOT EXIST `car` (
  `id` bigint NOT NULL,
  `model` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `series` int DEFAULT NULL,
  `color` varchar(80) COLLATE utf8mb4_general_ci DEFAULT (_utf8mb4'ЧЕРНЫЙ'),
  PRIMARY KEY (`id`)
);
