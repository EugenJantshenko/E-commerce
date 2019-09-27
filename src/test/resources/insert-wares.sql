INSERT INTO `ware_category` (`category_name`) VALUES ('Category 1');
INSERT INTO `ware_category` (`category_name`) VALUES ('Category 2');
INSERT INTO `ware_category` (`category_name`) VALUES ('Category 3');
INSERT INTO `ware_category` (`category_name`) VALUES ('Category 4');
INSERT INTO `ware_category` (`category_name`) VALUES ('Category 5');

INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 1',1);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 2',2);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 3',3);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 4',4);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 5',1);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 6',2);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 7',3);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 8',3);
INSERT INTO `ware_type` (`type_name`,`category_id`) VALUES ('Type 9',4);

INSERT INTO `ware_name` (`ware_name`) VALUES ('ware 1');
INSERT INTO `ware_name` (`ware_name`) VALUES ('ware 2');
INSERT INTO `ware_name` (`ware_name`) VALUES ('ware 3');
INSERT INTO `ware_name` (`ware_name`) VALUES ('ware 4');
INSERT INTO `ware_name` (`ware_name`) VALUES ('ware 5');

INSERT INTO `manufacturer` (`manufacturer_name`) VALUES ('manufacturerId 1');
INSERT INTO `manufacturer` (`manufacturer_name`) VALUES ('manufacturerId 2');
INSERT INTO `manufacturer` (`manufacturer_name`) VALUES ('manufacturerId 3');
INSERT INTO `manufacturer` (`manufacturer_name`) VALUES ('manufacturerId 4');
INSERT INTO `manufacturer` (`manufacturer_name`) VALUES ('manufacturerId 5');


INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (1,'1000','1w23456',2,1);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','12e3456',2,2);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','12q3456',1,3);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (3,'1000','123r456',4,4);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (3,'1000','123f456',5,1);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (4,'1000','12qw3456',1,2);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (3,'1000','123z456',1,3);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','123x456',4,4);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','12c3456',3,1);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (1,'1000','12v3456',3,2);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (5,'1000','123b456',1,3);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (4,'1000','123n456',1,4);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','123m456',3,1);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (1,'1000','1234cc56',4,2);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (4,'1000','123h456',5,3);
INSERT INTO `ware` (`manufacturer_id`,`price`,`serial_number`,`name_id`,`type_id`) VALUES (2,'1000','123j456',3,4);

