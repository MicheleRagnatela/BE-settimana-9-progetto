PGDMP     &    4                z            films    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    24868    films    DATABASE     a   CREATE DATABASE films WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE films;
                postgres    false            ?            1259    24886    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    24885    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    24886    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   z       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    209            ]           2606    24892    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?   ?  x?u?Kr?0??|
-?? ?%6ā`c^?P??X"ȑ%#?@|?\a.6d??lf??U_???<??\?aL??[䑝??[@??7uaa(?ꐶz[6??I?{???KQ
?KQ!/TSDTVH?9Q?r(???g??̡????,"??^k???h?(1t^p??g?2??8P?%/_b?6?????֨?UE	???4?b?S)??E?p???^?N??d????;?z?狏f???x??(??@r?>?D?wC?F3??=U?e?j???b8??{0???E???Â?(,M!??"?t?QMc?W?9???z??3Y?캓????O??f??'??0??Z??_?s???x?b???hoG?I????UM?u??s?ծ??a<??p???????2??F?Q?? ??Q????N?????I????I?~M?y{߮??A܊??t?>??_ϙw4E???<?Å???U?5????r??H\K??H?Wǲ????զ     