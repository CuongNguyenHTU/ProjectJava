USE [master]
GO
/****** Object:  Database [Employee_Management]    Script Date: 09/01/2019 5:27:23 PM ******/
CREATE DATABASE [Employee_Management]
GO
ALTER DATABASE [Employee_Management] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Employee_Management].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Employee_Management] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Employee_Management] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Employee_Management] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Employee_Management] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Employee_Management] SET ARITHABORT OFF 
GO
ALTER DATABASE [Employee_Management] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Employee_Management] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Employee_Management] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Employee_Management] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Employee_Management] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Employee_Management] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Employee_Management] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Employee_Management] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Employee_Management] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Employee_Management] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Employee_Management] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Employee_Management] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Employee_Management] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Employee_Management] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Employee_Management] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Employee_Management] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Employee_Management] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Employee_Management] SET RECOVERY FULL 
GO
ALTER DATABASE [Employee_Management] SET  MULTI_USER 
GO
ALTER DATABASE [Employee_Management] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Employee_Management] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Employee_Management] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Employee_Management] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Employee_Management] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Employee_Management', N'ON'
GO
USE [Employee_Management]
GO
/****** Object:  Table [dbo].[DanToc]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[DanToc](
	[MaDT] [char](10) NOT NULL,
	[TenDanToc] [nvarchar](50) NULL,
 CONSTRAINT [PK_DanToc] PRIMARY KEY CLUSTERED 
(
	[MaDT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[MaNV] [char](10) NOT NULL,
	[MaDT] [char](10) NULL,
	[MaQT] [char](10) NULL,
	[MaTT] [char](10) NULL,
	[MaTG] [char](10) NULL,
	[HoLotEml] [nvarchar](50) NULL,
	[TenEml] [nvarchar](50) NULL,
	[BietDanh] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[Tuoi] [int] NULL,
	[GioiTinh] [nvarchar](5) NULL,
	[NoiSinh] [nvarchar](100) NULL,
	[SoCMND] [int] NULL,
	[NgayCapCMND] [date] NULL,
	[NoiCap] [char](10) NULL,
	[StatusHonNhan] [nvarchar](50) NULL,
	[DiaChiThuongTru] [nvarchar](100) NULL,
	[DiaChiTamTru] [nvarchar](100) NULL,
	[DiaChiKhanCap] [nvarchar](100) NULL,
	[TenNguoiThan] [nvarchar](100) NULL,
	[Image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GioiTinh]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioiTinh](
	[GioiTinh] [nvarchar](5) NOT NULL,
 CONSTRAINT [PK_GioiTinh] PRIMARY KEY CLUSTERED 
(
	[GioiTinh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HonNhan]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HonNhan](
	[StatusHonNhan] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HonNhan] PRIMARY KEY CLUSTERED 
(
	[StatusHonNhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QuocTich]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[QuocTich](
	[MaQT] [char](10) NOT NULL,
	[TenQuocTich] [nvarchar](50) NULL,
 CONSTRAINT [PK_QuocTich] PRIMARY KEY CLUSTERED 
(
	[MaQT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TinhThanh]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TinhThanh](
	[MaTT] [char](10) NOT NULL,
	[TenTinhThanh] [nvarchar](50) NULL,
 CONSTRAINT [PK_TinhThanh] PRIMARY KEY CLUSTERED 
(
	[MaTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TonGiao]    Script Date: 09/01/2019 5:27:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TonGiao](
	[MaTG] [char](10) NOT NULL,
	[TenTonGiao] [nvarchar](50) NULL,
 CONSTRAINT [PK_TonGiao] PRIMARY KEY CLUSTERED 
(
	[MaTG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[DanToc] ([MaDT], [TenDanToc]) VALUES (N'Brau      ', N'Dân tộc Brâu')
INSERT [dbo].[DanToc] ([MaDT], [TenDanToc]) VALUES (N'Hoa       ', N'Dân tộc Hoa')
INSERT [dbo].[DanToc] ([MaDT], [TenDanToc]) VALUES (N'KhoMe     ', N'Dân tộc Khơ Me')
INSERT [dbo].[DanToc] ([MaDT], [TenDanToc]) VALUES (N'Kinh      ', N'Dân tộc Kinh')
INSERT [dbo].[DanToc] ([MaDT], [TenDanToc]) VALUES (N'Nung      ', N'Dân tộc Nùng')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A001      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Thị', N'Liễu', N'Liễu cute', CAST(N'1993-12-13' AS Date), 26, N'Nữ', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'DongNai   ', N'Married', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Nguyễn Văn Cường', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A002      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Văn ', N'Cường', N'CuongAcoustic', CAST(N'1997-09-20' AS Date), 21, N'Nam', N'Bệnh viện Đồng Nai', 272736958, CAST(N'2015-03-19' AS Date), N'DongNai   ', N'Married', N'475 A Điện Biên Phủ', N'475 A Điện Biên Phủ', N'475 A Điện Biên Phủ', N'Mai Chi Tho', N'C:\Users\Admin\Pictures\ImageOfMy.jpg')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A003      ', N'Nung      ', N'VietNam   ', N'SaiGon    ', N'NhoGiao   ', N'Nguyễn Lê Minh', N'Thái', N'Thái Xàm', CAST(N'1997-09-10' AS Date), 21, N'Nam', N'Bệnh viện Sài Gòn', 121212121, CAST(N'2015-06-19' AS Date), N'SaiGon    ', N'Married', N'475A Điện Biên Phủ', N'475A Điện Biên Phủ', N'475A Điện Biên Phủ', N'Dương', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A004      ', N'Kinh      ', N'China     ', N'SaiGon    ', N'NhoGiao   ', N'Huỳnh Minh', N'Dục', N'Dục ngáo', CAST(N'1997-01-15' AS Date), 21, N'Nam', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'SaiGon    ', N'Single', N'Quận 8, TP.HCM', N'Quận 8, TP.HCM', N'Quận 8, TP.HCM', N'Game', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A005      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Thị', N'Liễu', N'Liễu cute', CAST(N'1993-12-13' AS Date), 26, N'Nữ', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'DongNai   ', N'Married', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Nguyễn Văn Cường', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A006      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Thị', N'Liễu', N'Liễu cute', CAST(N'1993-12-13' AS Date), 26, N'Nữ', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'DongNai   ', N'Married', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Nguyễn Văn Cường', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A007      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Thị', N'Liễu', N'Liễu cute', CAST(N'1993-12-13' AS Date), 26, N'Nữ', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'DongNai   ', N'Married', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Nguyễn Văn Cường', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A008      ', N'Kinh      ', N'VietNam   ', N'DongNai   ', N'ThienChua ', N'Nguyễn Thị', N'Liễu', N'Liễu cute', CAST(N'1993-12-13' AS Date), 26, N'Nữ', N'Bệnh viện Hưng Yên', 272736954, CAST(N'2013-06-19' AS Date), N'DongNai   ', N'Married', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Tam hiệp, Biên hòa', N'Nguyễn Văn Cường', N'')
INSERT [dbo].[Employee] ([MaNV], [MaDT], [MaQT], [MaTT], [MaTG], [HoLotEml], [TenEml], [BietDanh], [NgaySinh], [Tuoi], [GioiTinh], [NoiSinh], [SoCMND], [NgayCapCMND], [NoiCap], [StatusHonNhan], [DiaChiThuongTru], [DiaChiTamTru], [DiaChiKhanCap], [TenNguoiThan], [Image]) VALUES (N'A009      ', N'Brau      ', N'VietNam   ', N'SaiGon    ', N'HoiGiao   ', N'Mai Quốc', N'Thịnh', N'Thịnh Sleep', CAST(N'1993-12-13' AS Date), 26, N'Nam', N'Trung ương 2', 272736954, CAST(N'2013-06-19' AS Date), N'SaiGon    ', N'Single', N'475 A Điện Biên Phủ', N'475 A Điện Biên Phủ', N'475 A Điện Biên Phủ', N'Akula', N'C:\Users\Admin\Desktop\thinh.png')
INSERT [dbo].[GioiTinh] ([GioiTinh]) VALUES (N'Nam')
INSERT [dbo].[GioiTinh] ([GioiTinh]) VALUES (N'Nữ')
INSERT [dbo].[HonNhan] ([StatusHonNhan]) VALUES (N'Married')
INSERT [dbo].[HonNhan] ([StatusHonNhan]) VALUES (N'Single')
INSERT [dbo].[QuocTich] ([MaQT], [TenQuocTich]) VALUES (N'China     ', N'Trung Quốc')
INSERT [dbo].[QuocTich] ([MaQT], [TenQuocTich]) VALUES (N'Japan     ', N'Nhật Bản')
INSERT [dbo].[QuocTich] ([MaQT], [TenQuocTich]) VALUES (N'PhanLan   ', N'Phần Lan')
INSERT [dbo].[QuocTich] ([MaQT], [TenQuocTich]) VALUES (N'ThuySy    ', N'Thụy Sỹ')
INSERT [dbo].[QuocTich] ([MaQT], [TenQuocTich]) VALUES (N'VietNam   ', N'Việt Nam')
INSERT [dbo].[TinhThanh] ([MaTT], [TenTinhThanh]) VALUES (N'BinhDuong ', N'Bình Dương')
INSERT [dbo].[TinhThanh] ([MaTT], [TenTinhThanh]) VALUES (N'DongNai   ', N'Đồng Nai')
INSERT [dbo].[TinhThanh] ([MaTT], [TenTinhThanh]) VALUES (N'HaNoi     ', N'Hà Nội')
INSERT [dbo].[TinhThanh] ([MaTT], [TenTinhThanh]) VALUES (N'LangSon   ', N'Lạng Sơn')
INSERT [dbo].[TinhThanh] ([MaTT], [TenTinhThanh]) VALUES (N'SaiGon    ', N'Sài Gòn')
INSERT [dbo].[TonGiao] ([MaTG], [TenTonGiao]) VALUES (N'HoiGiao   ', N'Hồi Giáo')
INSERT [dbo].[TonGiao] ([MaTG], [TenTonGiao]) VALUES (N'NhoGiao   ', N'Nho Giáo')
INSERT [dbo].[TonGiao] ([MaTG], [TenTonGiao]) VALUES (N'PhatGiao  ', N'Phật Giáo')
INSERT [dbo].[TonGiao] ([MaTG], [TenTonGiao]) VALUES (N'ThienChua ', N'Công Giáo')
INSERT [dbo].[TonGiao] ([MaTG], [TenTonGiao]) VALUES (N'TinLanh   ', N'Tin Lành')
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_DanToc] FOREIGN KEY([MaDT])
REFERENCES [dbo].[DanToc] ([MaDT])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_DanToc]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_GioiTinh] FOREIGN KEY([GioiTinh])
REFERENCES [dbo].[GioiTinh] ([GioiTinh])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_GioiTinh]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_HonNhan] FOREIGN KEY([StatusHonNhan])
REFERENCES [dbo].[HonNhan] ([StatusHonNhan])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_HonNhan]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_QuocTich] FOREIGN KEY([MaQT])
REFERENCES [dbo].[QuocTich] ([MaQT])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_QuocTich]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_TinhThanh] FOREIGN KEY([MaTT])
REFERENCES [dbo].[TinhThanh] ([MaTT])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_TinhThanh]
GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_TonGiao] FOREIGN KEY([MaTG])
REFERENCES [dbo].[TonGiao] ([MaTG])
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_TonGiao]
GO
USE [master]
GO
ALTER DATABASE [Employee_Management] SET  READ_WRITE 
GO
