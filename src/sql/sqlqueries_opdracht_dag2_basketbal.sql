-- ex1
select * from team T join lid L on T.aanvoerder = L.lidnr;
-- ex2
select T.teamcode, L.achternaam from team T join lid L on T.aanvoerder = L.lidnr;
-- ex3
select T.teamcode, L.achternaam from team T join lid L on T.aanvoerder = L.lidnr where T.klasse = "B2000";
-- ex4
select B.lidnummer, L.voorletters, L.tussenvoegsel, L.achternaam, B.bedrag from boete B join lid L on B.lidnummer = L.lidnr;
-- ex5
select L.lidnr, L.voorletters, L.tussenvoegsel, L.achternaam, B.bedrag from boete B join lid L on B.lidnummer = L.lidnr where L.geslacht = "v" and L.woonplaats = "Volendam";
-- ex6
select L.lidnr, L.achternaam, T.teamcode, T.klasse from team T join lid L on T.aanvoerder = L.lidnr;
-- ex7
select lidnr, achternaam, woonplaats from lid where woonplaats != "Delft" and geslacht = "v";
-- ex8
select * from lid where jaartoe >= 2000 and jaartoe <= 2005;
-- ex9
select achternaam, geb_datum, TIMESTAMPDIFF(year, geb_datum, NOW()) from lid;
-- ex10
select achternaam, concat_ws(' ', woonplaats, postcode, straat, huisnr, toevoeging) as adres from lid;
-- ex11
select T.teamcode, T.teamnaam, concat(W.scorethuis, "-", W.scoreuit) as uitslag from team T join wedstrijd W on T.teamcode = W.teamthuis where W.scorethuis > W.scoreuit ORDER BY T.teamnaam ASC;
-- ex12
select betalingnummer from boete where TIMESTAMPDIFF(year, datumovertreding, NOW()) > 8;
-- dagdeel 4
-- ex1
select L.lidnr, L.achternaam, B.bedrag from boete B right outer join lid L on B.lidnummer = L.lidnr;
-- ex2
select L.lidnr, L.achternaam, count(B.lidnummer) `aantal boetes` from boete B right outer join lid L on B.lidnummer = L.lidnr group by L.lidnr;
-- ex3
select L.lidnr, L.achternaam, L.geslacht, T.teamcode, T.teamnaam from lid L left outer join team T on L.lidnr = T.aanvoerder;
-- ex4
select L.lidnr, L.achternaam, Bes.functie from (lid L left join team T on L.speelt_in = T.teamcode) left join Bestuurslid Bes on L.lidnr=Bes.lidnr where T.teamcode = 'REDGH1';

-- dagdeel 5
SET sql_mode =`ONLY_FULL_GROUP_BY`;
-- ex1
select jaartoe, count(*) `aantal leden toegetreden` from lid group by jaartoe order by jaartoe; 
-- ex2
select geslacht, count(*) from lid group by geslacht;
-- ex3
select L.lidnr, ROUND(AVG(B.bedrag),2) gemiddelde, COUNT(*) `n boetes` from lid L join boete B on L.lidnr = B.lidnummer group by L.lidnr;
-- ex4
select L.lidnr from lid L join boete B on L.lidnr = B.lidnummer group by L.lidnr having SUM(B.bedrag) > 15;
-- ex5
select L.voorletters, L.tussenvoegsel, L.achternaam, COUNT(*) `n boetes` from lid L join boete B on L.lidnr = B.lidnummer group by L.lidnr having count(L.lidnr) > 1;
-- ex6
select L.lidnr, min(B.bedrag) `min`, max(B.bedrag) `max` from lid L join boete B on L.lidnr = B.lidnummer group by L.lidnr; 
-- ex7
select T.teamcode, count(*) `n gewonnen` from team T right join wedstrijd W on T.teamcode = W.teamthuis where W.scorethuis > W.scoreuit group by T.teamcode;
-- ex8
select T.klasse, count(*) n from team T group by T.klasse order by count(*) DESC;
-- ex9
select S.sporthalnaam, count(*) `teams` from sporthal S join team t on S.sporthalnaam = T.thuishal group by S.sporthalnaam having count(*) > 1;

-- dagdeel 6
-- ex1
select lidnr from lid where woonplaats=(select woonplaats from lid where lidnr=83);
-- ex2
select B.betalingnummer, B.lidnummer, B.boetetype, B.datumovertreding, B.bedrag from boete B where B.lidnummer in (select L.lidnr from lid L where L.woonplaats = 'Amsterdam');
-- ex3
select datum,tijd,teamthuis,teamuit, concat_ws('-', scorethuis, scoreuit) `uitslag (thuis-uit)` from wedstrijd where teamthuis in (select teamcode from team where thuishal = 'Apollohal');
-- ex4
select betalingnummer, lidnummer, boetetype, datumovertreding, bedrag from boete where lidnummer in (select lidnr from lid where speelt_in = 'AMSTH1');
-- ex5
select voorletters, tussenvoegsel, achternaam from lid where lidnr in
	(select lidnummer from boete where bedrag = 
		(select max(bedrag) from boete) 
		group by lidnummer);
-- ex6
-- a
select voorletters, tussenvoegsel, achternaam, count(*) `n boetes` from lid join (select lidnummer from boete) tmp on tmp.lidnummer=lidnr group by lidnr;
-- b
select voorletters, tussenvoegsel, achternaam, count(*) `n boetes` from lid join (select lidnummer from boete) tmp on tmp.lidnummer=lidnr group by lidnr having count(*) > 2;
-- c
select voorletters, tussenvoegsel, achternaam, count(*) `n boetes` from lid join (select lidnummer from boete) tmp on tmp.lidnummer=lidnr group by lidnr having count(*) > (SELECT	count(*) FROM boete WHERE lidnummer = 201);

-- 6.2
-- ex 1
create view Apollohalteams as
select * from team where thuishal = 'Apollohal';
-- ex 2
select * from wedstrijd where teamthuis in (select teamcode from Apollohalteams) order by datum desc;
-- ex 3
create view deboetes as
select * from boete order by lidnummer;
-- ex 4
select lidnummer, round(avg(bedrag), 2) `gemiddeld bedrag`, count(*) `n boetes` from deboetes group by lidnummer;