package demo02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Iterator;


public class RecipeFile {

  // No one else should read or write
  // this file, so these strings
  // are private.
  private final static String NAME_TOK = 
    "NAME"; 
  private final static String INGREDIENTS_TOK = 
    "INGREDIENTS";

  public Recipe load(String fileName) 
    throws IOException {

    BufferedReader in = null;
    Recipe result = new Recipe();

    in = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = in.readLine()) != null){
      int pos = line.indexOf('=');
      String token = line.substring(0, pos);
      String value = line.substring(pos+1);
      if (token.equals(NAME_TOK)) {
        result.setName(value);
      } else if (token.equals(INGREDIENTS_TOK)) {
        int num_lines = Integer.parseInt(value);
        for (int i=0; i < num_lines; i++) {
          line = in.readLine();
          result.addIngredient(line);
        }
      }
    }
    in.close();
    return result;
  }

  public void save(String fileName, Recipe recipe) 
    throws IOException {

    PrintWriter out = new PrintWriter(
                            new FileWriter(fileName));

    out.println(NAME_TOK + "=" + 
                recipe.getName());
    out.println(INGREDIENTS_TOK + "=" + 
                recipe.getNumIngredients());

    Iterator itr = recipe.getIngredients();
    while (itr.hasNext()) {
      out.println(itr.next());
    }
    out.close();
  }
}


