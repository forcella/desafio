--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

-- Started on 2019-03-16 17:45:42

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
-- TOC entry 7 (class 2615 OID 16509)
-- Name: teste; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA teste;


ALTER SCHEMA teste OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 200 (class 1259 OID 16457)
-- Name: membros; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membros (
    id bigint NOT NULL,
    projeto bytea
);


ALTER TABLE public.membros OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16455)
-- Name: membros_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.membros_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membros_id_seq OWNER TO postgres;

--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 199
-- Name: membros_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.membros_id_seq OWNED BY public.membros.id;


--
-- TOC entry 201 (class 1259 OID 16466)
-- Name: membros_list_membros; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membros_list_membros (
    membros_id bigint NOT NULL,
    list_membros_id bigint NOT NULL
);


ALTER TABLE public.membros_list_membros OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16471)
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    id bigint NOT NULL,
    cargo character varying(255),
    cpf character varying(255),
    data_de_nascimento date,
    funcionario boolean,
    nome character varying(255)
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16469)
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_id_seq OWNER TO postgres;

--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 202
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.id;


--
-- TOC entry 205 (class 1259 OID 16482)
-- Name: projeto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.projeto (
    id bigint NOT NULL,
    data_fim timestamp without time zone,
    data_inicio timestamp without time zone,
    data_previsao_fim timestamp without time zone,
    descricao character varying(255),
    nome character varying(255),
    orcamento double precision,
    risco character varying(255),
    status character varying(255),
    gerente_id bigint
);


ALTER TABLE public.projeto OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16480)
-- Name: projeto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.projeto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.projeto_id_seq OWNER TO postgres;

--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 204
-- Name: projeto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.projeto_id_seq OWNED BY public.projeto.id;


--
-- TOC entry 198 (class 1259 OID 16396)
-- Name: to_do; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.to_do (
    id bigint NOT NULL,
    done boolean,
    task character varying(255)
);


ALTER TABLE public.to_do OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16394)
-- Name: to_do_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.to_do_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.to_do_id_seq OWNER TO postgres;

--
-- TOC entry 2866 (class 0 OID 0)
-- Dependencies: 197
-- Name: to_do_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.to_do_id_seq OWNED BY public.to_do.id;


--
-- TOC entry 2712 (class 2604 OID 16460)
-- Name: membros id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membros ALTER COLUMN id SET DEFAULT nextval('public.membros_id_seq'::regclass);


--
-- TOC entry 2713 (class 2604 OID 16474)
-- Name: pessoa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.pessoa_id_seq'::regclass);


--
-- TOC entry 2714 (class 2604 OID 16485)
-- Name: projeto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto ALTER COLUMN id SET DEFAULT nextval('public.projeto_id_seq'::regclass);


--
-- TOC entry 2711 (class 2604 OID 16399)
-- Name: to_do id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.to_do ALTER COLUMN id SET DEFAULT nextval('public.to_do_id_seq'::regclass);


--
-- TOC entry 2852 (class 0 OID 16457)
-- Dependencies: 200
-- Data for Name: membros; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.membros (id, projeto) FROM stdin;
1	\\xaced00057372001f62722e636f6d2e6269626c696f746563612e6d6f64656c2e50726f6a65746f000000000000000102000a4c00076461746146696d7400104c6a6176612f7574696c2f446174653b4c000a64617461496e6963696f71007e00014c000f64617461507265766973616f46696d71007e00014c000964657363726963616f7400124c6a6176612f6c616e672f537472696e673b4c0007676572656e74657400204c62722f636f6d2f6269626c696f746563612f6d6f64656c2f506573736f613b4c000269647400104c6a6176612f6c616e672f4c6f6e673b4c00046e6f6d6571007e00024c00096f7263616d656e746f7400124c6a6176612f6c616e672f446f75626c653b4c0005726973636f71007e00024c000673746174757371007e0002787070737200126a6176612e73716c2e54696d657374616d702618d5c80153bf650200014900056e616e6f737872000e6a6176612e7574696c2e44617465686a81014b597419030000787077080000016984711f8078000000007371007e000777080000016b5e3a2f807800000000740006737472696e677372001e62722e636f6d2e6269626c696f746563612e6d6f64656c2e506573736f6100000000000000010200064c0005636172676f71007e00024c000363706671007e00024c00106461746144654e617363696d656e746f71007e00014c000b66756e63696f6e6172696f7400134c6a6176612f6c616e672f426f6f6c65616e3b4c0002696471007e00044c00046e6f6d6571007e000278707400054c7563617374000b30343335303738313934337372000d6a6176612e73716c2e4461746514fa46683f3566970200007871007e0008770800000091d3a0f90078737200116a6176612e6c616e672e426f6f6c65616ecd207280d59cfaee0200015a000576616c75657870017372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b0200007870000000000000000174000541444d494e71007e0017740006737472696e67737200106a6176612e6c616e672e446f75626c6580b3c24a296bfb0402000144000576616c75657871007e001640c3880000000000740005424149584f740000
\.


--
-- TOC entry 2853 (class 0 OID 16466)
-- Dependencies: 201
-- Data for Name: membros_list_membros; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.membros_list_membros (membros_id, list_membros_id) FROM stdin;
1	2
\.


--
-- TOC entry 2855 (class 0 OID 16471)
-- Dependencies: 203
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (id, cargo, cpf, data_de_nascimento, funcionario, nome) FROM stdin;
1	Lucas	04350781943	1989-11-06	t	ADMIN
2	Vitoria	\N	\N	t	ADMIN
\.


--
-- TOC entry 2857 (class 0 OID 16482)
-- Dependencies: 205
-- Data for Name: projeto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.projeto (id, data_fim, data_inicio, data_previsao_fim, descricao, nome, orcamento, risco, status, gerente_id) FROM stdin;
1	\N	2019-03-16 00:00:00	2019-06-16 00:00:00	string	string	10000	BAIXO		1
\.


--
-- TOC entry 2850 (class 0 OID 16396)
-- Dependencies: 198
-- Data for Name: to_do; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.to_do (id, done, task) FROM stdin;
\.


--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 199
-- Name: membros_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.membros_id_seq', 1, true);


--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 202
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_id_seq', 2, true);


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 204
-- Name: projeto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.projeto_id_seq', 1, true);


--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 197
-- Name: to_do_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.to_do_id_seq', 1, false);


--
-- TOC entry 2718 (class 2606 OID 16465)
-- Name: membros membros_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membros
    ADD CONSTRAINT membros_pkey PRIMARY KEY (id);


--
-- TOC entry 2722 (class 2606 OID 16479)
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- TOC entry 2724 (class 2606 OID 16490)
-- Name: projeto projeto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 16401)
-- Name: to_do to_do_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.to_do
    ADD CONSTRAINT to_do_pkey PRIMARY KEY (id);


--
-- TOC entry 2720 (class 2606 OID 16492)
-- Name: membros_list_membros uk_ok0nm29cofueyqq63bisf57ue; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membros_list_membros
    ADD CONSTRAINT uk_ok0nm29cofueyqq63bisf57ue UNIQUE (list_membros_id);


--
-- TOC entry 2727 (class 2606 OID 16503)
-- Name: projeto fk_62s36dylrt3pgo5cl7q3bstsg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT fk_62s36dylrt3pgo5cl7q3bstsg FOREIGN KEY (gerente_id) REFERENCES public.pessoa(id);


--
-- TOC entry 2726 (class 2606 OID 16498)
-- Name: membros_list_membros fk_9rc18wsd4reuux6qw4so1f5y0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membros_list_membros
    ADD CONSTRAINT fk_9rc18wsd4reuux6qw4so1f5y0 FOREIGN KEY (membros_id) REFERENCES public.membros(id);


--
-- TOC entry 2725 (class 2606 OID 16493)
-- Name: membros_list_membros fk_ok0nm29cofueyqq63bisf57ue; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membros_list_membros
    ADD CONSTRAINT fk_ok0nm29cofueyqq63bisf57ue FOREIGN KEY (list_membros_id) REFERENCES public.pessoa(id);


-- Completed on 2019-03-16 17:45:42

--
-- PostgreSQL database dump complete
--

