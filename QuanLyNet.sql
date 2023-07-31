create database WHALENET
 
use WHALENET

create table NguoiDung(
	manv nvarchar(20) primary key,
	matkhau nvarchar(20),
	vaitro bit
);
drop table Users

insert into NguoiDung(manv, matkhau, vaitro) values 
('admin','123456',1),
('teo','123456',0),
('nhutanh','123456',0)

create table SanPham(
	masp nvarchar(20) primary key,
	tensp nvarchar(30),
	gia float,
	soluongcon int,
	hinh nvarchar(50),
	manv nvarchar(20),
	foreign key(manv) references NguoiDung(manv),
);
drop table SanPham


insert into SanPham(masp,tensp,gia,soluongcon,hinh,manv) values
(1,N'Sting',10000,30,N'sting.png','teo'),
(2,N'Coca',10000,30,N'coca.png','nhutanh'),
(3,N'Mì Xào',15000,30,N'mixao.png','admin'),
(4,N'Mì 2 Trứng',18000,30,N'mi2trung.png','teo')

create table NhanVien(
	id_nv nvarchar(20) primary key,
	tennv nvarchar(20),
	gioitinh bit,
	sdt int,
	email nvarchar(100),
	luong int,
	hinh nvarchar(40),
	manv nvarchar(20),
	foreign key(manv) references NguoiDung(manv),
)

insert into NhanVien(id_nv,tennv,gioitinh,sdt,email,luong,hinh,manv) values
('nv_1',N'Hoài An',1,12345,'hoaian@gmail,com',25000,N'nope.png','teo'),
('nv_2',N'Nhựt Anh',1,1124,'NhutAnh@gmail,com',20000,N'nope.png','teo'),
('nv_3',N'Dũng Linh',1,0909,'Linh@gmail,com',25000,N'nope.png','teo')



create table ThanhVien(
	matv nvarchar(20) primary key,
	manv nvarchar(20),
	sotiendanap1 float,
	ngaytao date,
	matkhaunguoidung nvarchar(20)
	foreign key(manv) references NguoiDung(manv),
)
drop table nguoidung

insert into ThanhVien(matv,manv,sotiendanap1,ngaytao,matkhaunguoidung) values
('tv_1','teo',200,'2017-12-20','an12345'),
('tv_2','teo',230,'2019-10-7','han0093')

create table May(
	Id_may nvarchar(20) primary key,
	ngay date,
	masp nvarchar(20),
	foreign key(masp) references SanPham(masp),
);

insert into May(Id_may,ngay,masp) values
('may_1','2022-11-16',1),
('may_2','2022-11-20',2)

create table HoaDon(
	mahoadon nvarchar(20) primary key,
	ngaylapHD date,
	Id_may nvarchar(20),
	id_nv nvarchar(20),
	foreign key(Id_may) references May(Id_may),
	foreign key(id_nv) references NhanVien(id_nv),
)

insert into HoaDon(mahoadon,ngaylapHD,Id_may,id_nv) values
('hd_1','2022-11-16','may_1','nv_1'),
('hd_2','2022-11-20','may_2','nv_2')

create table ChiTietHoaDon(
	mahoadon nvarchar(20),
	foreign key(mahoadon) references HoaDon(mahoadon),
	masp nvarchar(20),
	foreign key(masp) references SanPham(masp),
	soluong int,
	primary key(mahoadon,masp)

)
insert into  ChiTietHoaDon(mahoadon,masp,soluong) values
('hd_1',1,1),
('hd_2',2,2)



