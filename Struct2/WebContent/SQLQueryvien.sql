USE [master]
GO
CREATE DATABASE [QLRVDT]
GO
USE [QLRVDT]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].ACCOUNT(
	[id_account] [int] IDENTITY(1,1) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[fullname] [nvarchar](250) NOT NULL,
	[phone] [nvarchar](20) NOT NULL,
	[address] [nvarchar](500) NULL,
	[role] [varchar](10) NOT NULL,
	[status] [varchar](10) NOT NULL,
	[sex] [nvarchar](10) NULL,
	[code_mail] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_ACCOUNT] PRIMARY KEY CLUSTERED 
(
	[id_account] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk361@gmail.com', N'123456',N'Trần Việt Thức',N'01689955141',N'Thành phố Quy Nhơn - Bình Định',N'Admin',N'Active',N'Nam','XH5R7A')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk362@gmail.com', N'123456',N'Nguyễn Văn Lâm',N'01636371979',N'Thành phố Nam Kỳ - Quảng Nam',N'Admin',N'Active',N'Nam','15AH8L')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk363@gmail.com', N'123456',N'Lê Văn Viễn',N'01689955141',N'Thành phố Đà Nẵng',N'User',N'InActive',N'Nam','QS7RP9')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk364@gmail.com', N'123456',N'Nguyễn Văn Linh',N'01689955141',N'Thành phố Đà Nẵng',N'User',N'Block',N'Nữ','QD73F5')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk365@gmail.com', N'123456',N'Dương Thị Thảo Trang',N'01689955141',N'Thành phố Pleiku',N'User',N'Block',N'Nữ','QD73F8')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk366@gmail.com', N'123456',N'Trương Văn Thiện',N'01689955141',N'Thành phố Đà Nẵng',N'User',N'Active',N'Nam','QD73F6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk367@gmail.com', N'123456',N'Huỳnh Trí Lâm',N'01689955141',N'Thành phố Hồ Chí Minh',N'User',N'Active',N'Nam','TD73F6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk368@gmail.com', N'123456',N'Nguyễn Minh Trí',N'01688855141',N'Thành phố Đà Nẵng',N'User',N'Active',N'Nam','QDP3F6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk369@gmail.com', N'123456',N'Nguyễn Văn Đức',N'01689955141',N'Thành phố Tuy Hòa',N'User',N'Active',N'Nam','QD7OF6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk37@gmail.com', N'123456',N'Đinh Ngọc Điệp',N'01689955181',N'Thành phố Pleiku',N'User',N'Active',N'Nam','AD73F6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk371@gmail.com', N'123456',N'Tôn Nữ Hải Huyền',N'01689966141',N'Thành phố Quy Nhơn',N'User',N'Active',N'Nữ','QD23F6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk372@gmail.com', N'123456',N'Đặng Văn Hưng',N'01689955242',N'Thành phố Quy Nhơn',N'User',N'Active',N'Nam','QD73L6')
INSERT [dbo].[ACCOUNT] ([email], [password],[fullname],[phone],[address],[role],[status],[sex],[code_mail]) VALUES (N'cnttitk373@gmail.com', N'123456',N'Nguyễn Thị Mẩn',N'01689955282',N'Thành phố Tuy Hòa',N'User',N'Active',N'Nữ','QD73L6')


SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAIL](
	[id_mail] [int] IDENTITY(1,1) NOT NULL,
	[id_account] [int] NOT NULL,
	[title_mail] [nvarchar](250) NOT NULL,
	[content_mail] [nvarchar](500) NULL,
	[read_status] [varchar](10) NOT NULL,
	[input] [varchar](10) NULL,
	[out_put] [varchar](10) NULL,
	[date] [date] NOT NULL,
 CONSTRAINT [PK_MAIL] PRIMARY KEY CLUSTERED 
(
	[id_mail] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[MAIL]  WITH CHECK ADD  CONSTRAINT [FK_MAIL_ACCOUNT] FOREIGN KEY([id_account])
REFERENCES [dbo].[ACCOUNT] ([id_account])
GO
ALTER TABLE [dbo].[MAIL] CHECK CONSTRAINT [FK_MAIL_ACCOUNT]
GO
INSERT [dbo].[MAIL] ([id_account],[title_mail],[content_mail],[read_status],[input],[out_put],[date]) VALUES (1,N'Hello, welcome…',N'Hello, welcome…',N'yes',N'yes',N'',N'2017-03-01')
INSERT [dbo].[MAIL] ([id_account],[title_mail],[content_mail],[read_status],[input],[out_put],[date]) VALUES (4,N'Hello, welcome…',N'Hello, welcome…',N'yes',N'yes',N'',N'2017-03-01')
INSERT [dbo].[MAIL] ([id_account],[title_mail],[content_mail],[read_status],[input],[out_put],[date]) VALUES (4,N'Lỗi bài đăng',N'Lỗi bài đăng',N'yes',N'yes',N'',N'2017-03-01')
INSERT [dbo].[MAIL] ([id_account],[title_mail],[content_mail],[read_status],[input],[out_put],[date]) VALUES (4,N'Lỗi bài đăng',N'Lỗi bài đăng',N'no',N'',N'yes',N'2017-03-01')



SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[POST](
	[id_post] [int] IDENTITY(1,1) NOT NULL,
	[id_account] [int] NOT NULL,
	[title_post] [nvarchar](250) NOT NULL,
	[content_post] [nvarchar](500) NULL,
	[type_product] [nvarchar](30) NOT NULL,
	[percent_product] [int] NOT NULL,
	[cost] [bigint] NOT NULL,
	[date_post] [date] NOT NULL,
	[address_product] [nvarchar](250) NOT NULL,
	[dateup] [datetime] NOT NULL,
	[type_post] [varchar](10) NOT NULL,
	[view_post] [int] NOT NULL,
	[accept] [varchar](10) NOT NULL,
	[limit] [int] NOT NULL
 CONSTRAINT [PK_POST] PRIMARY KEY CLUSTERED 
(
	[id_post] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[POST] ([id_account],[title_post],[content_post],[type_product],[percent_product],[cost],[date_post],[address_product],[dateup],[type_post],[view_post],[accept],[limit]) VALUES (1,N'Galaxy S6',N'Cần bán DT S6',N'SamSung',90,11000000,N'2017-03-01',N'Quy Nhon',N'2017-03-01 11:30:00',N'VIP',50,N'TRUE',90)
INSERT [dbo].[POST] ([id_account],[title_post],[content_post],[type_product],[percent_product],[cost],[date_post],[address_product],[dateup],[type_post],[view_post],[accept],[limit]) VALUES (3,N'Nokia 520',N'Cần bán DT Nokia 520',N'Nokia',50,3000000,N'2017-03-01',N'Quy Nhon',N'2017-03-01 11:30:00',N'VIP',150,N'TRUE',30)
INSERT [dbo].[POST] ([id_account],[title_post],[content_post],[type_product],[percent_product],[cost],[date_post],[address_product],[dateup],[type_post],[view_post],[accept],[limit]) VALUES (2,N'Sony Z5',N'Cần bán DT Sony Z5',N'Sony',50,12000000,N'2017-03-02',N'Quy Nhon',N'2017-03-02 15:30:00',N'Normal',250,N'FALSE',30)
INSERT [dbo].[POST] ([id_account],[title_post],[content_post],[type_product],[percent_product],[cost],[date_post],[address_product],[dateup],[type_post],[view_post],[accept],[limit]) VALUES (4,N'LG G3',N'Cần bán DT LG G3',N'LG',60,2500000,N'2017-03-02',N'Da Nang',N'2017-03-02 17:30:00',N'Normal',70,N'FALSE',30)
INSERT [dbo].[POST] ([id_account],[title_post],[content_post],[type_product],[percent_product],[cost],[date_post],[address_product],[dateup],[type_post],[view_post],[accept],[limit]) VALUES (4,N'Iphone 7',N'Cần bán DT Iphone 7',N'Iphone',100,19000000,N'2017-03-02',N'Da Nang',N'2017-03-02 19:30:00',N'VIP',0,N'BLOCK',90)


SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IMAGES](
	[id_post] [int] NOT NULL,
	[address] [nvarchar](250) NULL,
 )
GO

ALTER TABLE [dbo].[IMAGES]  WITH CHECK ADD  CONSTRAINT [FK_MAIL_POST] FOREIGN KEY([id_post])
REFERENCES [dbo].[POST] ([id_post])
GO
ALTER TABLE [dbo].[IMAGES] CHECK CONSTRAINT [FK_MAIL_POST]
GO
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (1,N'/image/01/01.jpg')
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (1,N'/image/01/01.jpg')
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (2,N'/image/02/01.jpg')
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (3,N'/image/03/01.jpg')
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (4,N'/image/04/01.jpg')
INSERT [dbo].[IMAGES] ([id_post],[address]) VALUES (5,N'/image/05/01.jpg')



SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMMENT](
	[id_post] [int] NOT NULL,
	[id_account] [int] NOT NULL,
	[date] [date] NULL,
	[comment] [nvarchar](250) NULL,
 )
GO

ALTER TABLE [dbo].[COMMENT]  WITH CHECK ADD  CONSTRAINT [FK_COMMENT_POST] FOREIGN KEY([id_post])
REFERENCES [dbo].[POST] ([id_post])
GO
ALTER TABLE [dbo].[COMMENT] CHECK CONSTRAINT [FK_COMMENT_POST]
GO
ALTER TABLE [dbo].[COMMENT]  WITH CHECK ADD  CONSTRAINT [FK_COMMENT_ACCOUNT] FOREIGN KEY([id_account])
REFERENCES [dbo].[ACCOUNT] ([id_account])
GO
ALTER TABLE [dbo].[COMMENT] CHECK CONSTRAINT [FK_COMMENT_ACCOUNT]
GO
INSERT [dbo].[COMMENT] ([id_post],[id_account],[date],[comment]) VALUES (1,2,N'2017-03-02',N'Hello')
INSERT [dbo].[COMMENT] ([id_post],[id_account],[date],[comment]) VALUES (2,1,N'2017-03-02',N'Google Bye')
INSERT [dbo].[COMMENT] ([id_post],[id_account],[date],[comment]) VALUES (2,2,N'2017-03-02',N'Hi, Thức')
INSERT [dbo].[COMMENT] ([id_post],[id_account],[date],[comment]) VALUES (3,3,N'2017-03-02',N'Hi, Lâm')
INSERT [dbo].[COMMENT] ([id_post],[id_account],[date],[comment]) VALUES (4,4,N'2017-03-02',N'Hi, Linh')

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LIKE](
	[id_account] [int] NOT NULL,
	[id_post] [int] NOT NULL,
 )
GO
ALTER TABLE [dbo].[POST]  WITH CHECK ADD  CONSTRAINT [FK_POST_ACCOUNT] FOREIGN KEY([id_account])
REFERENCES [dbo].[ACCOUNT] ([id_account])

GO
ALTER TABLE [dbo].[LIKE]  WITH CHECK ADD  CONSTRAINT [FK_LIKE_POST] FOREIGN KEY([id_post])
REFERENCES [dbo].[POST] ([id_post])

GO
ALTER TABLE [dbo].[LIKE] CHECK CONSTRAINT [FK_LIKE_POST]

GO
ALTER TABLE [dbo].[LIKE]  WITH CHECK ADD  CONSTRAINT [FK_LIKE_ACCOUNT] FOREIGN KEY([id_account])
REFERENCES [dbo].[ACCOUNT] ([id_account])

GO
ALTER TABLE [dbo].[LIKE] CHECK CONSTRAINT [FK_LIKE_ACCOUNT]

GO
INSERT [dbo].[LIKE] ([id_account],[id_post]) VALUES (1,2)
INSERT [dbo].[LIKE] ([id_account],[id_post]) VALUES (4,1)
INSERT [dbo].[LIKE] ([id_account],[id_post]) VALUES (4,2)
INSERT [dbo].[LIKE] ([id_account],[id_post]) VALUES (4,3)

GO  
CREATE FULLTEXT CATALOG account_fts AS DEFAULT;
GO
ALTER FULLTEXT CATALOG account_fts 
REBUILD WITH ACCENT_SENSITIVITY=OFF;
GO
-- Check Accentsensitivity
--SELECT FULLTEXTCATALOGPROPERTY('account_fts', 'accentsensitivity');
--GO  
CREATE FULLTEXT INDEX ON ACCOUNT
 (   
  [fullname]
     Language 1066,  
  [address]
     Language 1066,  
  [sex]   
     Language 1066       
 )   
  KEY INDEX [PK_ACCOUNT]   
      ON account_fts;   

GO  
CREATE FULLTEXT CATALOG post_fts AS DEFAULT;
GO
ALTER FULLTEXT CATALOG post_fts 
REBUILD WITH ACCENT_SENSITIVITY=OFF;
GO
-- Check Accentsensitivity
--SELECT FULLTEXTCATALOGPROPERTY('account_fts', 'accentsensitivity');
--GO  
CREATE FULLTEXT INDEX ON POST
 (   
  [title_post]
     Language 1066,  
  [content_post]
     Language 1066,  
  [address_product]   
     Language 1066       
 )   
  KEY INDEX [PK_POST]   
      ON post_fts;   
GO
