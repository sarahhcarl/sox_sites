package jobs;

import play.jobs.*;
import play.Logger;
import java.io.*;

import models.Enhancer;
public class AddEnhancerInfo extends Job {
	
	public void doJob() throws IOException {
		
		//Set soxBindPattern as either common, Dunique or SoxNunique
		//If soxBindPattern is Dunique or SoxNunique, set transcomp as either true or false
		//Set expressionStage to GBE or St16 (or null)
		//Set expressionSubset to NB, neurons or midline (or null)
		
		Logger.info("Adding Sox binding pattern info");
		
		BufferedReader Dreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.DDam.unique.enhancers.txt"));
		String Dline = null;
		while ((Dline = Dreader.readLine()) != null) {
			String enhancerName = Dline;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			if (thisEnhancer != null) {
				thisEnhancer.soxBindPattern = "Dunique";
				BufferedReader transcompreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.DDam.unique.SoxNtranscomp.enhancers.txt"));
				String newline = null;
				while ((newline = transcompreader.readLine()) != null) {
					String e = newline;
					if (e == enhancerName){
						thisEnhancer.transcomp = true;
					} else {
						thisEnhancer.transcomp = false;
					}	
				}
				transcompreader.close();
				BufferedReader expreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.CNS.all.in.DDam.unique.enhancers.txt"));
				String newline1 = null;
				while ((newline1 = expreader.readLine()) != null) {
					String e = newline1;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "GBE";
						BufferedReader nb = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.NBs.all.in.DDam.unique.enhancers.txt"));
						String nbline = null;
						while ((nbline = nb.readLine()) != null) {
							String e1 = nbline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "NB";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						nb.close();
						BufferedReader neuron = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.Neurons.all.in.DDam.unique.enhancers.txt"));
						String neuronline = null;
						while ((neuronline = neuron.readLine()) != null) {
							String e2 = neuronline;
							if (e2 == enhancerName) {
								thisEnhancer.expressionSubset = "neurons";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						neuron.close();
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.DDam.unique.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e3 = midline;
							if (e3 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				expreader.close();
				BufferedReader st16 = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/St16.CNS.all.in.DDam.unique.enhancers.txt"));
				String st16line = null;
				while ((st16line = st16.readLine()) != null) {
					String e = st16line;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "St16";
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.DDam.unique.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e1 = midline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				st16.close();
				thisEnhancer.save();
			}	
		}
		Dreader.close();
		
		BufferedReader SoxNreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.unique.enhancers.txt"));
		String SoxNline = null;
		while ((SoxNline = SoxNreader.readLine()) != null) {
			String enhancerName = SoxNline;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			if (thisEnhancer != null) {
				thisEnhancer.soxBindPattern = "SoxNunique";	
				BufferedReader transcompreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.unique.Dtranscomp.uniqueEnhancers.txt"));
				String newline = null;
				while ((newline = transcompreader.readLine()) != null) {
					String e = newline;
					if (e == enhancerName){
						thisEnhancer.transcomp = true;
					} else {
						thisEnhancer.transcomp = false;
					}	
				}
				transcompreader.close();
				BufferedReader expreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.CNS.all.in.SoxNDam.unique.enhancers.txt"));
				String newline2 = null;
				while ((newline2 = expreader.readLine()) != null) {
					String e = newline2;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "GBE";
						BufferedReader nb = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.NBs.all.in.SoxNDam.unique.enhancers.txt"));
						String nbline = null;
						while ((nbline = nb.readLine()) != null) {
							String e1 = nbline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "NB";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						nb.close();
						BufferedReader neuron = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.Neurons.all.in.SoxNDam.unique.enhancers.txt"));
						String neuronline = null;
						while ((neuronline = neuron.readLine()) != null) {
							String e2 = neuronline;
							if (e2 == enhancerName) {
								thisEnhancer.expressionSubset = "neurons";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						neuron.close();
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.SoxNDam.unique.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e3 = midline;
							if (e3 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				expreader.close();
				BufferedReader st16 = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/St16.CNS.all.in.SoxNDam.unique.enhancers.txt"));
				String st16line = null;
				while ((st16line = st16.readLine()) != null) {
					String e = st16line;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "St16";
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.SoxNDam.unique.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e1 = midline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				st16.close();
				thisEnhancer.save();
			}	
		}
		SoxNreader.close();
		
		BufferedReader Creader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.DDam.common.uniqueEnhancers.txt"));
		String Cline = null;
		while ((Cline = Creader.readLine()) != null) {
			String enhancerName = Cline;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			if (thisEnhancer != null) {
				thisEnhancer.soxBindPattern = "common";
				BufferedReader expreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.CNS.all.in.SoxNDam.DDam.common.enhancers.txt"));
				String newline = null;
				while ((newline = expreader.readLine()) != null) {
					String e = newline;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "GBE";
						BufferedReader nb = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.NBs.all.in.SoxNDam.DDam.common.enhancers.txt"));
						String nbline = null;
						while ((nbline = nb.readLine()) != null) {
							String e1 = nbline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "NB";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						nb.close();
						BufferedReader neuron = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/GBE.Neurons.all.in.SoxNDam.DDam.common.enhancers.txt"));
						String neuronline = null;
						while ((neuronline = neuron.readLine()) != null) {
							String e2 = neuronline;
							if (e2 == enhancerName) {
								thisEnhancer.expressionSubset = "neurons";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						neuron.close();
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.SoxNDam.DDam.common.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e3 = midline;
							if (e3 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				expreader.close();
				BufferedReader st16 = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/St16.CNS.all.in.SoxNDam.DDam.common.enhancers.txt"));
				String st16line = null;
				while ((st16line = st16.readLine()) != null) {
					String e = st16line;
					if (e == enhancerName) {
						thisEnhancer.expressionStage = "St16";
						BufferedReader mid = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Midline.all.in.SoxNDam.DDam.common.enhancers.txt"));
						String midline = null;
						while ((midline = mid.readLine()) != null) {
							String e1 = midline;
							if (e1 == enhancerName) {
								thisEnhancer.expressionSubset = "midline";
							} else {
								thisEnhancer.expressionSubset = "other";
							}
						}
						mid.close();
					} else {
						thisEnhancer.expressionStage = "other";
						thisEnhancer.expressionSubset = "other";
					}
				}
				st16.close();
				thisEnhancer.transcomp = null;
				thisEnhancer.save();
			}
		}	
		Creader.close();
	}
}
