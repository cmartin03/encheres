/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  martin
 * Created: 11 déc. 2022
 */

-- Table: public.utilisateur

-- DROP TABLE IF EXISTS public.utilisateur;

CREATE TABLE IF NOT EXISTS public.utilisateur
(
    utilisateur_id integer NOT NULL DEFAULT nextval('utilisateur_id_seq'::regclass),
    nom character varying COLLATE pg_catalog."default",
    prenom character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    code_postal character varying COLLATE pg_catalog."default",
    CONSTRAINT utilisateur_pkey PRIMARY KEY (utilisateur_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.utilisateur
    OWNER to postgres;