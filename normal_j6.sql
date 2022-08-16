-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 16, 2022 lúc 10:34 AM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `normal_j6`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `fullname`, `email`) VALUES
(1, 'BaoDG', '$2a$10$XxFjLh7wpFojGLuaH1iB8O18EhATGzr7yGApojkGeXFGQ9g.obxhq', 'Dương Gia Bảo', 'baodgpc01660@fpt.edu.vn'),
(5, 'HoLy', '$2a$10$ie02Sj0ilUDtwvbAgjjbBuzjFSj4532Fd.SY13edgZHCX81moJpmS', 'Bao', 'baodgpc01660@fpt.edu.vn'),
(9, 'HoLy2', '$2a$10$DfkG7ibPVeGEAprvZqLK0ezwZD8fQUvunZZczYUdAwpMA8B9k4vl2', 'Dương Gia Bảo Baro', 'baodgpc01660@fpt.edu.vn'),
(10, 'trungtt', '$2a$10$XxFjLh7wpFojGLuaH1iB8O18EhATGzr7yGApojkGeXFGQ9g.obxhq', 'Trần Thành Trung', 'trungttpc01815@fpt.edu.vn'),
(11, 'HoLy', '$2a$10$3cS0AK1HBxUUVRmckIDYC.15HhwSOVIUgGxT9b5JDBAjUcVGW0l5y', 'HoLy', 'duonggiabaobao87@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `authorities`
--

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL,
  `idAccounts` int(11) NOT NULL,
  `idRoles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `authorities`
--

INSERT INTO `authorities` (`id`, `idAccounts`, `idRoles`) VALUES
(1, 1, 2),
(2, 1, 1),
(3, 10, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Áo thun'),
(2, 'Áo khoác'),
(3, 'Áo sơ mi'),
(4, 'Quần');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `Id` int(11) NOT NULL,
  `contents` varchar(1000) NOT NULL,
  `create_at` date NOT NULL,
  `status` bit(1) NOT NULL,
  `Id_user` int(11) NOT NULL,
  `Id_product` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetails`
--

CREATE TABLE `orderdetails` (
  `Id` int(11) NOT NULL,
  `Id_order` int(11) NOT NULL,
  `Id_product` int(11) NOT NULL,
  `UnitPrice` float NOT NULL,
  `Quanlity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orderdetails`
--

INSERT INTO `orderdetails` (`Id`, `Id_order`, `Id_product`, `UnitPrice`, `Quanlity`) VALUES
(32, 19, 3, 200000, 1),
(33, 19, 4, 200000, 1),
(34, 20, 4, 200000, 1),
(35, 20, 8, 120000, 1),
(36, 20, 3, 200000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `Id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `OderDate` date NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`Id`, `idUser`, `Username`, `OderDate`, `address`) VALUES
(19, 1, ' BaoDG', '2022-08-15', 'Cần Thơ'),
(20, 1, ' BaoDG', '2022-08-15', 'Cà Mau');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `UnitPrice` float NOT NULL,
  `Image` varchar(50) NOT NULL,
  `ProductDate` date NOT NULL,
  `Avaible` tinyint(1) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Description` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`Id`, `Name`, `UnitPrice`, `Image`, `ProductDate`, `Avaible`, `CategoryId`, `Quantity`, `Description`) VALUES
(2, 'Áo thun 1', 100000, 'AT1.1.jpg', '2022-08-09', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(3, 'Áo thun 2', 200000, 'AT2.1.jpg', '2022-08-09', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(4, 'Áo thun 3', 200000, 'AT3.1.jpg', '2022-08-08', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(8, 'Áo thun 4', 120000, 'AT4.1.jpg', '2022-08-15', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(9, 'Áo thun 5', 120000, 'AT5.1.jpg', '2022-08-15', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(11, 'Áo thun 6', 120000, 'AT6.1.jpg', '2022-08-15', 1, 1, 100, 'o Thun Cổ Tròn Đơn Giản Y Nguyên Bản Ver52 Chất liệu: Cotton Compact Thành phần: 100% Cotton - Thân thiện - Thấm hút thoát ẩm - Mềm mại - Kiểm soát mùi - Điều hòa nhiệt + Họa tiết may miếng đắp'),
(12, 'Áo khoác 1', 350000, 'AK1.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù\r\nThành phần: 100% poly\r\n, Cản gió\r\n, Trượt nước\r\n, Thoáng Khí, Vừa vặn tối ưu\r\n, Chống thấm nước nhiều giờ liền\r\n, Bảo vệ chống tác động môi trường'),
(13, 'Áo khoác 2', 350000, 'AK2.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù\r\nThành phần: 100% poly\r\n, Cản gió\r\n, Trượt nước\r\n, Thoáng Khí, Vừa vặn tối ưu\r\n, Chống thấm nước nhiều giờ liền\r\n, Bảo vệ chống tác động môi trường'),
(14, 'Áo khoác 3', 350000, 'AK3.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù\nThành phần: 100% poly\n, Cản gió\n, Trượt nước\n, Thoáng Khí, Vừa vặn tối ưu\n, Chống thấm nước nhiều giờ liền\n, Bảo vệ chống tác động môi trường'),
(15, 'Áo khoác 4', 350000, 'AK4.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(16, 'Áo khoác 5', 350000, 'AK5.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(17, 'Áo khoác 6', 350000, 'AK6.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(18, 'Áo khoác 7', 350000, 'AK7.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(19, 'Áo khoác 8', 350000, 'AK8.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(20, 'Áo khoác 9', 350000, 'AK9.1.jpg', '2022-08-15', 1, 2, 100, 'Chất liệu: Vải Dù Thành phần: 100% poly , Cản gió , Trượt nước , Thoáng Khí, Vừa vặn tối ưu , Chống thấm nước nhiều giờ liền , Bảo vệ chống tác động môi trường'),
(21, 'Áo sơ mi 1', 230000, 'ASM1.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(22, 'Áo sơ mi 2', 230000, 'ASM2.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(23, 'Áo sơ mi 3', 230000, 'ASM3.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(24, 'Áo sơ mi 4', 230000, 'ASM4.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(25, 'Áo sơ mi 5', 230000, 'ASM5.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(26, 'Áo sơ mi 6', 230000, 'ASM6.1.jpg', '2022-08-15', 1, 3, 100, 'hất liệu: Kate Thành phần: 12% modal và 88% superfine - Ít nhăn và dễ ủi - Nhanh khô và thoáng mát HDSD: - Áo sơ mi màu phơi trong bóng râm để tránh bạc màu phần vai áo - Áo sơ mi trắng có thể phơi ngoài nắng để áo trắng sáng hơn ( không phơi quá lâu )'),
(27, 'Quần 1', 320000, 'Q1.1.jpg', '2022-08-15', 1, 4, 100, 'Chất liệu: Vải Quần Tây Thành phần: 82% polyester 14% rayon 4% spandex - Mềm mại - Thoáng khí - Thân thiện với mối trường - Hút ẩm tốt'),
(28, 'Quần 2', 320000, 'Q2.1.jpg', '2022-08-15', 1, 4, 100, 'Chất liệu: Vải Quần Tây Thành phần: 82% polyester 14% rayon 4% spandex - Mềm mại - Thoáng khí - Thân thiện với mối trường - Hút ẩm tốt'),
(29, 'Quần 3', 320000, 'Q3.1.jpg', '2022-08-15', 1, 4, 100, 'Chất liệu: Vải Quần Tây Thành phần: 82% polyester 14% rayon 4% spandex - Mềm mại - Thoáng khí - Thân thiện với mối trường - Hút ẩm tốt');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'USER');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`,`username`);

--
-- Chỉ mục cho bảng `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idAccounts` (`idAccounts`),
  ADD KEY `idRoles` (`idRoles`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK7o5bgyo34r2f7m47x6lp4tigf` (`Id_user`),
  ADD KEY `FK4bp0knd6y5wso4371s3m3jyy6` (`Id_product`);

--
-- Chỉ mục cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Id_product` (`Id_product`),
  ADD KEY `Id_order` (`Id_order`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idUser` (`idUser`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `CategoryId` (`CategoryId`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `authorities`
--
ALTER TABLE `authorities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`idAccounts`) REFERENCES `accounts` (`id`),
  ADD CONSTRAINT `authorities_ibfk_2` FOREIGN KEY (`idRoles`) REFERENCES `roles` (`id`);

--
-- Các ràng buộc cho bảng `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK4bp0knd6y5wso4371s3m3jyy6` FOREIGN KEY (`Id_product`) REFERENCES `products` (`Id`),
  ADD CONSTRAINT `FK7o5bgyo34r2f7m47x6lp4tigf` FOREIGN KEY (`Id_user`) REFERENCES `accounts` (`id`);

--
-- Các ràng buộc cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`Id_product`) REFERENCES `products` (`Id`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`Id_order`) REFERENCES `orders` (`Id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK2l4rkovgv5osmix1yg693o6oc` FOREIGN KEY (`idUser`) REFERENCES `accounts` (`id`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK1j46fyje6cc7rycyr8mrmcvy0` FOREIGN KEY (`CategoryId`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
