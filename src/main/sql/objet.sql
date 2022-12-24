-- Table: public.objet

--DROP TABLE IF EXISTS public.objet;

CREATE SEQUENCE IF NOT EXISTS public.objet_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1
    OWNED BY objet.objet_id;

ALTER SEQUENCE public.objet_id_seq
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS public.objet
(
    objet_id integer NOT NULL DEFAULT nextval('objet_id_seq'::regclass),
    libelle character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    debut_enchere timestamp without time zone NOT NULL,
    fin_enchere timestamp without time zone NOT NULL,
    prix_initial integer NOT NULL,
    utilisateur_id integer,
    CONSTRAINT objet_pkey PRIMARY KEY (objet_id),
    CONSTRAINT utilisateur_fk FOREIGN KEY (utilisateur_id)
        REFERENCES public.utilisateur (utilisateur_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.objet
    OWNER to postgres;
-- Index: fki_f

-- DROP INDEX IF EXISTS public.fki_f;

CREATE INDEX IF NOT EXISTS fki_f
    ON public.objet USING btree
    (utilisateur_id ASC NULLS LAST)
    TABLESPACE pg_default;