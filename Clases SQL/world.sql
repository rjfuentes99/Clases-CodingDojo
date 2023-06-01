SELECT name,language,percentage FROM languages 
JOIN countries ON languages.country_id = countries.id
where language = 'Slovene' ORDER BY percentage DESC;

SELECT countries.name,count(cities.name) FROM countries
JOIN cities ON cities.country_code = countries.code
GROUP BY countries.name
ORDER BY count(cities.name)  DESC;

SELECT cities.name,cities.population FROM cities
LEFT JOIN countries ON cities.country_id = countries.id
WHERE countries.name = 'Mexico' AND cities.population > 500000
ORDER BY cities.population DESC;

SELECT name,language,percentage FROM languages 
JOIN countries ON languages.country_id = countries.id
where percentage > 86
ORDER BY percentage DESC;

SELECT name,surface_area,population FROM countries
WHERE surface_area < 501 AND population > 100000;

SELECT name, government_form, capital, life_expectancy FROM countries
WHERE government_form = 'Constitutional Monarchy' AND capital > 200 AND life_expectancy > 75;

SELECT countries.name, cities.name, cities.district, cities.population FROM cities
JOIN countries ON cities.country_id = countries.id
WHERE cities.district = 'Buenos Aires'AND cities.population > 500000;

SELECT region, count(name) FROM countries
group by region
ORDER BY count(name) DESC
