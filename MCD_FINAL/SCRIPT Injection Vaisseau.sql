INSERT INTO vaisseau (id_planete, id_type_vaisseau) VALUES ((SELECT id_planete FROM planete WHERE nom_planete='IvanWorld'), (SELECT id_type_vaisseau FROM type_vaisseau WHERE nom_type_vaisseau='Bombardier'));