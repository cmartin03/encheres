/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  martin
 * Created: 24 déc. 2022
 */

-- Table: public.enchere

-- DROP TABLE IF EXISTS public.enchere;

CREATE SEQUENCE IF NOT EXISTS public.enchere_enchere_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    ;

ALTER SEQUENCE public.enchere_enchere_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.enchere
(
    enchere_id integer NOT NULL DEFAULT nextval('enchere_enchere_id_seq'::regclass),
    prix integer,
    utilisateur_id integer,
    objet_id integer,
    CONSTRAINT enchere_pkey PRIMARY KEY (enchere_id),
    CONSTRAINT objet_fk FOREIGN KEY (objet_id)
        REFERENCES public.objet (objet_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT utilisateur_fk FOREIGN KEY (utilisateur_id)
        REFERENCES public.utilisateur (utilisateur_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.enchere
    OWNER to postgres;