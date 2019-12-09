package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    private HasAtLeast matcher;

    public HasFewerThan(int i, String string) {
        this.matcher = new HasAtLeast(i, string);
	}

	@Override
    public boolean matches(Player p) {
        return !this.matcher.matches(p);
    }

}
