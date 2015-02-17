/*! SET storage_engine=INNODB */;

DROP TABLE IF EXISTS `test_responses`;

/* ========================================================================== *
 * RESPONSES TABLE                                                            *
 * ========================================================================== */
CREATE TABLE `test_responses` (

  /* IDs (record and kill bill's UUID) */
  `record_id`                 INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `kb_account_id`             CHAR(36)         NOT NULL,
  `kb_payment_id`             CHAR(36)         NOT NULL,
  `kb_payment_transaction_id` CHAR(36)         NOT NULL,
  `kb_tenant_id`              CHAR(36)         NOT NULL,

  /* Transaction details */
  `transaction_type`          VARCHAR(32)      NOT NULL,
  `amount`                    NUMERIC(15,9)    NOT NULL,
  `currency`                  CHAR(3)      DEFAULT NULL,

  /* Additional data */
  `additional_data`           LONGTEXT     DEFAULT NULL,
  `created_date`              DATETIME         NOT NULL,

  /* Primary key and unique constraints */
  INDEX(`kb_payment_transaction_id`),
  INDEX(`kb_payment_id`),
  PRIMARY KEY(`record_id`)
) /*! CHARACTER SET utf8 COLLATE utf8_bin */;

/* ========================================================================== *
 * PAYMENT METHODS TABLE                                                      *
 * ========================================================================== */

DROP TABLE IF EXISTS `test_payment_methods`;

CREATE TABLE `test_payment_methods` (

  /* IDs (record and kill bill's UUID) */
  `record_id`             INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `kb_payment_method_id`  CHAR(36)         NOT NULL,
  `kb_account_id`         CHAR(36)         NOT NULL,
  `kb_tenant_id`          CHAR(36)         NOT NULL,

  /* Credit card details */
  `cc_first_name`         VARCHAR(255) DEFAULT NULL,
  `cc_last_name`          VARCHAR(255) DEFAULT NULL,
  `cc_type`               VARCHAR(255) DEFAULT NULL,
  `cc_exp_month`          VARCHAR(255) DEFAULT NULL,
  `cc_exp_year`           VARCHAR(255) DEFAULT NULL,
  `cc_number`             VARCHAR(255) DEFAULT NULL,
  `cc_last_4`             VARCHAR(255) DEFAULT NULL,
  `cc_start_month`        VARCHAR(255) DEFAULT NULL,
  `cc_start_year`         VARCHAR(255) DEFAULT NULL,
  `cc_issue_number`       VARCHAR(255) DEFAULT NULL,
  `cc_verification_value` VARCHAR(255) DEFAULT NULL,
  `cc_track_data`         VARCHAR(255) DEFAULT NULL,

  /* Credit card address */
  `address1`              VARCHAR(255) DEFAULT NULL,
  `address2`              VARCHAR(255) DEFAULT NULL,
  `city`                  VARCHAR(255) DEFAULT NULL,
  `state`                 VARCHAR(255) DEFAULT NULL,
  `zip`                   VARCHAR(255) DEFAULT NULL,
  `country`               VARCHAR(255) DEFAULT NULL,

  /* Additional data */
  `token`                 VARCHAR(255) DEFAULT NULL,
  `additional_data`       LONGTEXT     DEFAULT NULL,
  `is_default`            BOOLEAN          NOT NULL DEFAULT FALSE,
  `is_deleted`            BOOLEAN          NOT NULL DEFAULT FALSE,
  `created_date`          DATETIME         NOT NULL,
  `updated_date`          DATETIME         NOT NULL,

  /* Primary key and unique constraints */
  UNIQUE KEY(`kb_payment_method_id`),
  PRIMARY KEY(`record_id`)

) /*! CHARACTER SET utf8 COLLATE utf8_bin */;
