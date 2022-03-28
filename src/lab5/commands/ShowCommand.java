package lab5.commands;

import lab5.collection.MoviesCollection;
import lab5.exceptions.collection_exceptions.CollectionException;
import lab5.movie_classes.Movie;

public class ShowCommand extends Command {
    private String tag = "show";
    private String description = "SHOW ... shows all collection's elements";

    public ShowCommand(MoviesCollection moviesCollection) {
        super(moviesCollection);
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String execute(String[] args) throws CollectionException {
        MoviesCollection moviesCollection = super.getMoviesCollection();
        if (moviesCollection.getCollectionSize() == 0) {
            throw new CollectionException("Collection is empty");
        }
        StringBuilder result = new StringBuilder();
        for (Movie movie : moviesCollection.getCollection()) {
            result.append(movie.toString()).append("\n");
        }
        return result.toString();
    }


}
