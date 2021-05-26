create TABLE IF NOT EXISTS `tbl_item`(
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`category_id` BIGINT(20) NOT NULL,
`brand_id` BIGINT(20) NOT NULL,
`general` VARCHAR(512) NULL,
`status` TINYINT(1) DEFAULT 1 NOT NULL,
PRIMARY KEY(`id`),
FOREIGN KEY (category_id) REFERENCES tbl_category (`id`),
FOREIGN KEY (brand_id) REFERENCES tbl_brand (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `app`.`tbl_item` (`name`, `category_id`, `brand_id`, `status`) VALUES ('Sony android TV S001', '118', '1', '1');
INSERT INTO `app`.`tbl_item` (`name`, `category_id`, `brand_id`, `status`) VALUES ('LG smart TV L001', '118', '1', '0');
INSERT INTO `app`.`tbl_item` (`name`, `category_id`, `brand_id`, `status`) VALUES ('LG smart TV L002', '118', '1', '1');
