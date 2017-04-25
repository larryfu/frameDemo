package cn.larry.demo.solr.feeds;

import org.apache.lucene.queries.function.ValueSource;
import org.apache.solr.search.FunctionQParser;
import org.apache.solr.search.SyntaxError;
import org.apache.solr.search.ValueSourceParser;

/**
 * Created by fugz on 2016/4/14.
 */
public class FeedsValueSourceParser extends ValueSourceParser {
    @Override
    public ValueSource parse(FunctionQParser functionQParser) throws SyntaxError {
        return null;
    }
}
