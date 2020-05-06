import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
		private String dataSource;
		private String[] commands;
		private Command[] movements;
  
  		public CSVReader() {
   		 	this.commands = null;
    			this.dataSource = null;
 		 }

  		public String getDataSource() {
    			return dataSource;
 		 }

 		 public void setDataSource(String dataSource) {
   			 this.dataSource = dataSource;
   			 if (dataSource == null) {
      			commands = null;
    		} else
      			readCSV();
			movements = new Command[commands.length];
			for (int i=0;i<commands.length;i++){
				if (commands[i].length()==5) {
                                        movements[i] = new Mover("0");
					movements[i].setCommand(commands[i]);
                                }
                                else {
                                        movements[i] = new Transformar("0");
					movements[i].setCommand(commands[i]);
                                }
			}
  		}

  
 		 public Command[] requestCommands() {
    			return movements;
 		 }
  
  		private void readCSV() {
    			try {
     			 	BufferedReader file = new BufferedReader(new FileReader(dataSource));
        
      				String line = file.readLine();
      				if (line != null) {
       				 commands = line.split(",");
       			 	line = file.readLine();
      			}
      			file.close();
    			} catch (IOException erro) {
     			 erro.printStackTrace();
   		 	}
 		}
  	}
