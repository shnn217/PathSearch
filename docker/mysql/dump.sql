CREATE TABLE `node` (
  `id` varbinary(16) ,
  `name` varchar(255) NOT NULL,
  `parent_id` varbinary(16) DEFAULT NULL,
  `type` ENUM ('d', 'f'),
  `path` varchar(5000)
);




