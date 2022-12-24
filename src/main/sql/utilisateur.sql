-- Table: public.utilisateur

--DROP TABLE IF EXISTS public.utilisateur;


CREATE SEQUENCE IF NOT EXISTS public.utilisateur_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY utilisateur.utilisateur_id;

ALTER SEQUENCE public.utilisateur_id_seq
    OWNER TO postgres;


CREATE TABLE IF NOT EXISTS public.utilisateur
(
    utilisateur_id integer NOT NULL DEFAULT nextval('utilisateur_id_seq'::regclass),
    nom character varying COLLATE pg_catalog."default",
    prenom character varying COLLATE pg_catalog."default",
    email character varying COLLATE pg_catalog."default",
    code_postal character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT utilisateur_pkey PRIMARY KEY (utilisateur_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.utilisateur
    OWNER to postgres;