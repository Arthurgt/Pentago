/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2018-03-18 11:10:33                          */
/*==============================================================*/


drop index Baza_PK;

drop table Baza;

/*==============================================================*/
/* Table: Baza                                                  */
/*==============================================================*/
create table Baza (
   Nick                 VARCHAR(30)          not null,
   Zwyciestwa           INT4                 not null,
   Przegrane            INT4                 not null,
   Remisy               INT4                 not null,
   constraint PK_BAZA primary key (Nick)
);

/*==============================================================*/
/* Index: Baza_PK                                               */
/*==============================================================*/
create unique index Baza_PK on Baza (
Nick
);

