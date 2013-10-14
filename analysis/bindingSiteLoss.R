library(RPostgreSQL)
drv <- dbDriver("PostgreSQL")
con <- dbConnect(drv, dbname="sox_db")

# Be sure to specify the name in the dataset variable and the correct table name in the SQL queries.

dataset <- "D_St16"

#pairwise_ms <- dbGetQuery(con, "select * from  where soxbindpattern='SoxNunique'")
#pairwise_my <- dbGetQuery(con, "select * from soxn_notranscomp_pairwise_my where soxbindpattern='SoxNunique'")
#pairwise_mp <- dbGetQuery(con, "select * from soxn_notranscomp_pairwise_mp where soxbindpattern='SoxNunique'")

pairwise_ms <- D_st16_ms
pairwise_my <- D_st16_my
pairwise_mp <- D_st16_mp
  
mel <- dbGetQuery(con, "select * from d_st16, tfsite_species ts, species s WHERE d_st16.tfsite_id=ts.tfsites_id AND ts.species_id = s.id AND s.name='dmel'")
num_mel <- nrow(mel)
num_ms <- nrow(pairwise_ms)
num_my <- nrow(pairwise_my)
num_mp <- nrow(pairwise_mp)
br_lens <- c(0.06629, 0.14007, 0.36588)
ratios <- c(num_ms/num_mel, num_my/num_mel, num_mp/num_mel)
linreg <- lm(ratios ~ br_lens)
output_file_path <- paste('/home/sarah/utilities/play-1.2.7/sox_sites/analysis/', dataset, sep='')
output_file <- paste(output_file_path, 'rateOfLoss.txt', sep="_")
sink(output_file)
print(linreg)
sink()

dbDisconnect(con)

