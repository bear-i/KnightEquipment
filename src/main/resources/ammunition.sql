--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.6 (Ubuntu 10.6-0ubuntu0.18.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: equipment; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA equipment;


ALTER SCHEMA equipment OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: armorplating; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.armorplating (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    weigth integer NOT NULL,
    kind text NOT NULL,
    material text NOT NULL
);


ALTER TABLE equipment.armorplating OWNER TO postgres;

--
-- Name: bow; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.bow (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    tax double precision NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL,
    form text NOT NULL
);


ALTER TABLE equipment.bow OWNER TO postgres;

--
-- Name: chainarmor; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.chainarmor (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL,
    ringssize text NOT NULL
);


ALTER TABLE equipment.chainarmor OWNER TO postgres;

--
-- Name: helmet; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.helmet (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL,
    form text NOT NULL
);


ALTER TABLE equipment.helmet OWNER TO postgres;

--
-- Name: shield; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.shield (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    tax double precision NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL,
    form text NOT NULL
);


ALTER TABLE equipment.shield OWNER TO postgres;

--
-- Name: spear; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.spear (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    tax double precision NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL,
    kind text NOT NULL
);


ALTER TABLE equipment.spear OWNER TO postgres;

--
-- Name: sword; Type: TABLE; Schema: equipment; Owner: postgres
--

CREATE TABLE equipment.sword (
    id integer NOT NULL,
    name text NOT NULL,
    price double precision NOT NULL,
    tax double precision NOT NULL,
    length text NOT NULL,
    weigth integer NOT NULL,
    material text NOT NULL
);


ALTER TABLE equipment.sword OWNER TO postgres;

--
-- Data for Name: armorplating; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.armorplating (id, name, price, weigth, kind, material) FROM stdin;
102	White armour	2000	22	Full	Steel
101	Maximilian armour	1500	25	Full	Steel
103	Gothic armour	1800	30	Full	Steel
105	Cuirasse armour	1400	18	Partial	Steel
104	Kastenbrust armour	1450	28	Partial	Steel
\.


--
-- Data for Name: bow; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.bow (id, name, price, tax, weigth, material, form) FROM stdin;
203	Skifian Bow	1500	0.100000000000000006	10	Cooper	Rounded
202	Japan Bow	1100	0.149999999999999994	6	Wood	Rounded
201	Long Bow	1050	0.100000000000000006	4	Wood	Flat
\.


--
-- Data for Name: chainarmor; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.chainarmor (id, name, price, weigth, material, ringssize) FROM stdin;
302	Bajdana chain armour	1200	8	Metal	Large
305	Bahter chain armor	1300	10	Metal	Small
303	Jushman chain armour	1350.5	10	Metal	Large
304	Colontar chain armour	1250	9	Metal	Large
301	Hauberk chain armor	1000	6	Metal	Small
\.


--
-- Data for Name: helmet; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.helmet (id, name, price, weigth, material, form) FROM stdin;
401	Greek helmet	800	5	Bronze	Conical
404	Shumer helmet	850	7	Bronze	Conical
403	Negaus helmet	900	6	Bronze	Spheroconic
402	Rime helmet	950	6	Cooper	Eggshaped
\.


--
-- Data for Name: shield; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.shield (id, name, price, tax, weigth, material, form) FROM stdin;
502	Bakler shield	600	0.100000000000000006	6	Metal	Almondshaped
504	Parma shield	710	0.130000000000000004	9	Metal	Square
501	Adarga shield	640	0.149999999999999994	10	Leather	Round
505	Pelta shield	690	0.149999999999999994	8	Bronze	Round
506	Tarch shield	815	0.119999999999999996	10	Metal	Square
503	Clipeus shield	800	0.149999999999999994	11	Cooper	Oval
\.


--
-- Data for Name: spear; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.spear (id, name, price, tax, weigth, material, kind) FROM stdin;
602	Goplit spear	415	0.0500000000000000028	2	Wood	Close_Combat
601	Sarissa spear	400	0.0500000000000000028	3	Wood	Throwing
603	Kirasa spear	450	0.0500000000000000028	3	Wood	Throwing
\.


--
-- Data for Name: sword; Type: TABLE DATA; Schema: equipment; Owner: postgres
--

COPY equipment.sword (id, name, price, tax, length, weigth, material) FROM stdin;
704	Akinak sword	510	0.200000000000000011	Short	2	Bronze
703	Kopis sword	555	0.200000000000000011	Long	4	Bronze
702	Hopesh sword	550	0.25	Long	5	Steel
701	Skifian sword	500	0.299999999999999989	Short	3	Bronze
\.


--
-- Name: armorplating armorplating_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.armorplating
    ADD CONSTRAINT armorplating_pk PRIMARY KEY (id);


--
-- Name: bow bow_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.bow
    ADD CONSTRAINT bow_pk PRIMARY KEY (id);


--
-- Name: chainarmor chainarmor_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.chainarmor
    ADD CONSTRAINT chainarmor_pk PRIMARY KEY (id);


--
-- Name: helmet helmet_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.helmet
    ADD CONSTRAINT helmet_pk PRIMARY KEY (id);


--
-- Name: shield shield_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.shield
    ADD CONSTRAINT shield_pk PRIMARY KEY (id);


--
-- Name: spear spear_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.spear
    ADD CONSTRAINT spear_pk PRIMARY KEY (id);


--
-- Name: sword sword_pk; Type: CONSTRAINT; Schema: equipment; Owner: postgres
--

ALTER TABLE ONLY equipment.sword
    ADD CONSTRAINT sword_pk PRIMARY KEY (id);


--
-- Name: armorplating_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX armorplating_id_uindex ON equipment.armorplating USING btree (id);


--
-- Name: bow_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX bow_id_uindex ON equipment.bow USING btree (id);


--
-- Name: chainarmor_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX chainarmor_id_uindex ON equipment.chainarmor USING btree (id);


--
-- Name: helmet_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX helmet_id_uindex ON equipment.helmet USING btree (id);


--
-- Name: shield_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX shield_id_uindex ON equipment.shield USING btree (id);


--
-- Name: spear_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX spear_id_uindex ON equipment.spear USING btree (id);


--
-- Name: sword_id_uindex; Type: INDEX; Schema: equipment; Owner: postgres
--

CREATE UNIQUE INDEX sword_id_uindex ON equipment.sword USING btree (id);


--
-- PostgreSQL database dump complete
--

