/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  martin
 * Created: 24 déc. 2022
 */

-- Table: public.categorie

-- DROP TABLE IF EXISTS public.categorie;

CREATE SEQUENCE IF NOT EXISTS public.categorie_categorie_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY categorie.categorie_id;

ALTER SEQUENCE public.categorie_categorie_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.categorie
(
    categorie_id integer NOT NULL DEFAULT nextval('categorie_categorie_id_seq'::regclass),
    categorie character varying COLLATE pg_catalog."default",
    sous_categorie character varying COLLATE pg_catalog."default",
    CONSTRAINT categorie_pkey PRIMARY KEY (categorie_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.categorie
    OWNER to postgres;