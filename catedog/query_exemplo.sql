SELECT * FROM micro_produto;

SELECT TO_CHAR( DATE '2023-05-11', 'D' ) FROM DUAL;

 

select * 
    from disponibilidade d 
        inner join veterinario_especialidade ve
            on(d.idVeterinario=ve.idVeterinario)
                inner join veterinario v
                    on (ve.idVeterinario=v.id)
                        inner join especialidade e
                            on (ve.idEspecilidade= e.id)
    where d.diaSemana = TO_CHAR( DATE 'variavel', 'D' ) 
    and e.id = variavel