CREATE TABLE IF NOT EXISTS `tbl_category`(
`id` bigint (20) NOT NULL AUTO_INCREMENT,
`name` varchar (50) NOT NULL,
`parent_id` BIGINT(20) NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `name`(`name`),
CONSTRAINT `Parent_Id_reference` FOREIGN KEY (`parent_id`) REFERENCES tbl_category (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;