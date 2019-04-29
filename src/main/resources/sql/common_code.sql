CREATE TABLE `quiz`.`tb_common_code_group` (
  `group_id` CHAR(4) NOT NULL,
  `code_nm` VARCHAR(45) NOT NULL,
  `code_value` VARCHAR(100) NULL,
  `used` CHAR(1) NOT NULL DEFAULT 'Y',
  `cache` CHAR(1) NOT NULL DEFAULT 'N',
  `creator` int(10) unsigned NOT NULL,
  `updater` int(10) unsigned NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`));

CREATE TABLE `quiz`.`tb_common_code_item` (
  `group_id` CHAR(4) NOT NULL,
  `code` CHAR(4) NOT NULL,
  `code_nm` VARCHAR(45) NOT NULL,
  `code_value` VARCHAR(100) NULL,
  `code_desc` VARCHAR(500) NULL,
  `used` CHAR(1) NOT NULL DEFAULT 'Y',
  `creator` int(10) unsigned NOT NULL,
  `updater` int(10) unsigned NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code`, `group_id`),
  INDEX `fk_common_code_item_01_idx` (`group_id` ASC),
  CONSTRAINT `fk_common_code_item_01`
    FOREIGN KEY (`group_id`)
    REFERENCES `quiz`.`tb_common_code_group` (`group_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);