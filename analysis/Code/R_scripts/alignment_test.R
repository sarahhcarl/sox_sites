drv <- dbDriver("PostgreSQL")
con <- dbConnect(drv, dbname="sox_db")

align <- dbGetQuery(con, "select align from alignment where alignment.id = 250997")