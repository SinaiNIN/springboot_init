CREATE TABLE IF NOT EXISTS `tbl_user` (
  `id` BIGINT(20) NOT NULL,
  `user_name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  UNIQUE INDEX `user_name_UNIQUE` (`user_name` ASC),
  PRIMARY KEY (`id`));
