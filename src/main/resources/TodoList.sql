PGDMP     9                     }            TodoList    9.6.24    9.6.24      k           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            l           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            m           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            n           1262    16408    TodoList    DATABASE     �   CREATE DATABASE "TodoList" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "TodoList";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            o           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            p           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16439    checklist_items    TABLE     �   CREATE TABLE public.checklist_items (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    status character varying(50) DEFAULT 'pending'::character varying,
    checklist_id integer
);
 #   DROP TABLE public.checklist_items;
       public         postgres    false    3            �            1259    16437    checklist_items_id_seq    SEQUENCE        CREATE SEQUENCE public.checklist_items_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.checklist_items_id_seq;
       public       postgres    false    190    3            q           0    0    checklist_items_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.checklist_items_id_seq OWNED BY public.checklist_items.id;
            public       postgres    false    189            �            1259    16425 
   checklists    TABLE     �   CREATE TABLE public.checklists (
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    created_at timestamp without time zone DEFAULT now(),
    user_id integer
);
    DROP TABLE public.checklists;
       public         postgres    false    3            �            1259    16423    checklists_id_seq    SEQUENCE     z   CREATE SEQUENCE public.checklists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.checklists_id_seq;
       public       postgres    false    3    188            r           0    0    checklists_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.checklists_id_seq OWNED BY public.checklists.id;
            public       postgres    false    187            �            1259    16411    users    TABLE     �   CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    email character varying(255),
    created_at timestamp without time zone DEFAULT now()
);
    DROP TABLE public.users;
       public         postgres    false    3            �            1259    16409    users_id_seq    SEQUENCE     u   CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       postgres    false    186    3            s           0    0    users_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;
            public       postgres    false    185            �           2604    16442    checklist_items id    DEFAULT     x   ALTER TABLE ONLY public.checklist_items ALTER COLUMN id SET DEFAULT nextval('public.checklist_items_id_seq'::regclass);
 A   ALTER TABLE public.checklist_items ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    189    190    190            �           2604    16428    checklists id    DEFAULT     n   ALTER TABLE ONLY public.checklists ALTER COLUMN id SET DEFAULT nextval('public.checklists_id_seq'::regclass);
 <   ALTER TABLE public.checklists ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    187    188    188            �           2604    16414    users id    DEFAULT     d   ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    185    186    186            h          0    16439    checklist_items 
   TABLE DATA               I   COPY public.checklist_items (id, name, status, checklist_id) FROM stdin;
    public       postgres    false    190   �!       t           0    0    checklist_items_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.checklist_items_id_seq', 1, true);
            public       postgres    false    189            f          0    16425 
   checklists 
   TABLE DATA               C   COPY public.checklists (id, name, created_at, user_id) FROM stdin;
    public       postgres    false    188   �!       u           0    0    checklists_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.checklists_id_seq', 1, true);
            public       postgres    false    187            d          0    16411    users 
   TABLE DATA               J   COPY public.users (id, username, password, email, created_at) FROM stdin;
    public       postgres    false    186   6"       v           0    0    users_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.users_id_seq', 1, true);
            public       postgres    false    185            �           2606    16445 $   checklist_items checklist_items_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.checklist_items
    ADD CONSTRAINT checklist_items_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.checklist_items DROP CONSTRAINT checklist_items_pkey;
       public         postgres    false    190    190            �           2606    16431    checklists checklists_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.checklists
    ADD CONSTRAINT checklists_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.checklists DROP CONSTRAINT checklists_pkey;
       public         postgres    false    188    188            �           2606    16420    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    186    186            �           2606    16422    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public         postgres    false    186    186            �           2606    16446 1   checklist_items checklist_items_checklist_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.checklist_items
    ADD CONSTRAINT checklist_items_checklist_id_fkey FOREIGN KEY (checklist_id) REFERENCES public.checklists(id) ON DELETE CASCADE;
 [   ALTER TABLE ONLY public.checklist_items DROP CONSTRAINT checklist_items_checklist_id_fkey;
       public       postgres    false    190    2025    188            �           2606    16432 "   checklists checklists_user_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.checklists
    ADD CONSTRAINT checklists_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE SET NULL;
 L   ALTER TABLE ONLY public.checklists DROP CONSTRAINT checklists_user_id_fkey;
       public       postgres    false    186    2021    188            h      x�3��K�O��K�,H�ӆ\1z\\\ g��      f   8   x�3�tI�̩TI,�.�4202�50�54U04�21�2��362321�4����� $�
b      d   @   x�3��,O��442615��s3s���s9��LuuMͬLL���L�,,M�b���� �A     