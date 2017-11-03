--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.21
-- Dumped by pg_dump version 9.2.21
-- Started on 2017-11-03 21:59:00

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1952 (class 1262 OID 16432)
-- Name: mylibrary; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mylibrary WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';


ALTER DATABASE mylibrary OWNER TO postgres;

\connect mylibrary

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 172 (class 1259 OID 24642)
-- Name: books_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE books_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.books_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 169 (class 1259 OID 16433)
-- Name: books; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE books (
    id integer DEFAULT nextval('books_id_seq'::regclass) NOT NULL,
    title character varying(128),
    author character varying(128),
    publishinghouse character varying(128),
    booktype character varying(128),
    booklanguage character varying(128),
    nrpages integer NOT NULL,
    isbn character varying(10) NOT NULL
);


ALTER TABLE public.books OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 24651)
-- Name: review_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE review_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.review_id_seq OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 24633)
-- Name: review; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE review (
    id integer DEFAULT nextval('review_id_seq'::regclass) NOT NULL,
    comment character varying(150),
    book_id integer
);


ALTER TABLE public.review OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 24645)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 16441)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id integer DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    phone character varying(15),
    email character varying(100) NOT NULL,
    paid boolean
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 1942 (class 0 OID 16433)
-- Dependencies: 169
-- Data for Name: books; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO books VALUES (4, 'Urzeala tronurilor- Vol2', 'George R.R. Martin', 'Carturesti', 'FANTASY', 'ENGLISH', 370, '101');
INSERT INTO books VALUES (5, 'Urzeala tronurilor- Vol3', 'George R.R. Martin', 'Carturesti', 'FANTASY', 'ENGLISH', 370, '102');
INSERT INTO books VALUES (6, 'Urzeala tronurilor- Vol4', 'George R.R. Martin', 'Carturesti', 'FANTASY', 'ENGLISH', 450, '103');
INSERT INTO books VALUES (7, 'Urzeala tronurilor- Vol5', 'George R.R. Martin', 'Carturesti', 'FANTASY', 'ENGLISH', 440, '104');
INSERT INTO books VALUES (8, 'Fluturi- Vol1', 'Irina Binder', 'For you', 'DRAMA', 'ROMANIAN', 240, '105');
INSERT INTO books VALUES (9, 'Fluturi- Vol2', 'Irina Binder', 'For you', 'DRAMA', 'ROMANIAN', 250, '106');
INSERT INTO books VALUES (10, 'Fluturi- Vol3', 'Irina Binder', 'For you', 'DRAMA', 'ROMANIAN', 210, '107');
INSERT INTO books VALUES (11, 'Harry Potter- Vol1', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 560, '118');
INSERT INTO books VALUES (12, 'Harry Potter- Vol2', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 660, '119');
INSERT INTO books VALUES (13, 'Harry Potter- Vol3', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 860, '1020');
INSERT INTO books VALUES (14, 'Harry Potter- Vol4', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 966, '1021');
INSERT INTO books VALUES (15, 'Harry Potter- Vol5', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 860, '1022');
INSERT INTO books VALUES (16, 'Harry Potter- Vol6', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 560, '1023');
INSERT INTO books VALUES (17, 'Harry Potter- Vol7', 'J.K. Rowling', 'Arthur', 'FANTASY', 'ENGLISH', 460, '1024');
INSERT INTO books VALUES (18, 'Pisicile razboinice-Vol1', 'Erin Hunter', 'Galaxia Copiilor', 'FANTASY', 'ROMANIAN', 324, '1027');
INSERT INTO books VALUES (2, 'Pisicile razboinice-Vol2', 'Erin Hunter', 'Galaxia Copiilor', 'FANTASY', 'ROMANIAN', 345, '1026');
INSERT INTO books VALUES (19, 'Pisicile razboinice-Vol3', 'Erin Hunter', 'Galaxia Copiilor', 'FANTASY', 'ROMANIAN', 555, '1028');
INSERT INTO books VALUES (21, 'Pisicile razboinice-Vol5', 'Erin Hunter', 'Galaxia Copiilor', 'FANTASY', 'ROMANIAN', 355, '1030');
INSERT INTO books VALUES (22, 'Ferma animalelor', 'George Orwell', 'Polirom', 'FANTASY', 'ROMANIAN', 432, '1045');
INSERT INTO books VALUES (25, 'Ferma animalelor', 'George Orwell', 'Polirom', 'FANTASY', 'ENGLISH', 432, '1048');
INSERT INTO books VALUES (27, 'Sub Dom-Vol1', 'Stephen King', 'Nemira', 'DRAMA', 'ENGLISH', 554, '1050');
INSERT INTO books VALUES (26, 'Sub Dom-Vol2', 'Stephen King', 'Nemira', 'DRAMA', 'ENGLISH', 345, '1051');
INSERT INTO books VALUES (28, 'Sub Dom-Vol3', 'Stephen King', 'Rao', 'DRAMA', 'ROMANIAN', 789, '1053');
INSERT INTO books VALUES (1, 'Hotul de carti- Vol1', 'Markus Zusak', 'Rao', 'DRAMA', 'ROMANIAN', 400, '1032');
INSERT INTO books VALUES (29, 'Sub Dom-Vol2', 'Markus Zusak', 'Rao', 'FANTASY', 'ENGLISH', 432, '1059');
INSERT INTO books VALUES (23, '1984', 'George Orwell', 'Polirom', 'FANTASY', 'ENGLISH', 348, '1047');


--
-- TOC entry 1956 (class 0 OID 0)
-- Dependencies: 172
-- Name: books_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('books_id_seq', 31, true);


--
-- TOC entry 1944 (class 0 OID 24633)
-- Dependencies: 171
-- Data for Name: review; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO review VALUES (1, 'This is a good book!I love it!', 1);
INSERT INTO review VALUES (2, 'It was borring!', 1);
INSERT INTO review VALUES (3, 'This is a nice book!', 2);
INSERT INTO review VALUES (4, 'this is a cool book', 3);
INSERT INTO review VALUES (6, 'this is boring', 3);
INSERT INTO review VALUES (5, 'this is very interesting!', 4);
INSERT INTO review VALUES (10, 'this is very funny!', 20);
INSERT INTO review VALUES (11, 'Nice try ', 5);
INSERT INTO review VALUES (13, 'this is boring', 4);


--
-- TOC entry 1957 (class 0 OID 0)
-- Dependencies: 174
-- Name: review_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('review_id_seq', 13, true);


--
-- TOC entry 1943 (class 0 OID 16441)
-- Dependencies: 170
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO users VALUES (1, 'George', 'Popescu', '0361700112', 'george.popescu@yahoo.com', true);
INSERT INTO users VALUES (2, 'George', 'Marin', '0361711112', 'george.marin@gmail.com', true);
INSERT INTO users VALUES (3, 'Maria', 'Enescu', '0361513412', 'maria.enescu@gmail.com', false);
INSERT INTO users VALUES (4, 'Louis', 'Griffin', '0361663412', 'louis.griffin@gmail.com', false);
INSERT INTO users VALUES (5, 'Peter', 'Griffin', '0361513512', 'peter.griffin@yahoo.com', true);
INSERT INTO users VALUES (7, 'Stewie', 'Griffin', '0361433323', 'stewie.griffin@gmail.com', true);
INSERT INTO users VALUES (8, 'Stewie', 'Griffin', '0364929212', 'griffin@gmail.com', false);
INSERT INTO users VALUES (10, 'Adam', 'Smith', '0364263456', 'adam.smith@gmail.com', false);
INSERT INTO users VALUES (11, 'Will', 'Smith', '0361513422', 'will.smith@gmail.com', true);
INSERT INTO users VALUES (12, 'Julie', 'Smith', '0361513492', 'julie.smith@gmail.com', true);
INSERT INTO users VALUES (14, 'Stewie', 'Smith', '0364263455', 'smith@gmail.com', true);
INSERT INTO users VALUES (13, 'Jennifer', 'Lame', '0365080810', 'jennifer.lame@yahoo.com', true);


--
-- TOC entry 1958 (class 0 OID 0)
-- Dependencies: 173
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 14, true);


--
-- TOC entry 1827 (class 2606 OID 24637)
-- Name: Unique; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY books
    ADD CONSTRAINT "Unique" UNIQUE (isbn);


--
-- TOC entry 1829 (class 2606 OID 16437)
-- Name: id_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY books
    ADD CONSTRAINT id_pk PRIMARY KEY (id);


--
-- TOC entry 1835 (class 2606 OID 24639)
-- Name: review_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY review
    ADD CONSTRAINT review_pkey PRIMARY KEY (id);


--
-- TOC entry 1831 (class 2606 OID 24650)
-- Name: unique_email; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT unique_email UNIQUE (email);


--
-- TOC entry 1833 (class 2606 OID 16445)
-- Name: user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-11-03 21:59:00

--
-- PostgreSQL database dump complete
--

