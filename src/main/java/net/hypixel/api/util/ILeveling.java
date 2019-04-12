/*
 *     Copyright (C) 2018  Hyperium <https://hyperium.cc/>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.hypixel.api.util;

public interface ILeveling {
    String EXP_FIELD = "networkExp";
    String LVL_FIELD = "networkLevel";
    double BASE = 10_000;
    double GROWTH = 2_500;
    double HALF_GROWTH = 0.5 * GROWTH;
    double REVERSE_PQ_PREFIX = -(BASE - 0.5 * GROWTH) / GROWTH;
    double REVERSE_CONST = REVERSE_PQ_PREFIX * REVERSE_PQ_PREFIX;
    double GROWTH_DIVIDES_2 = 2 / GROWTH;

    static double getLevel(double exp) {
        return exp <= 1 ? 1 : Math.floor(1 + REVERSE_PQ_PREFIX + Math.sqrt(REVERSE_CONST + GROWTH_DIVIDES_2 * exp));
    }

    static double getExactLevel(double exp) {
        return ILeveling.getLevel(exp) + ILeveling.getPercentageToNextLevel(exp);
    }

    static double getExpFromLevelToNext(double level) {
        return level < 1 ? BASE : GROWTH * (level - 1) + BASE;
    }

    static double getTotalExpToLevel(double level) {
        double lv = Math.floor(level), x0 = ILeveling.getTotalExpToFullLevel(lv);
        if (level == lv) return x0;
        return (ILeveling.getTotalExpToFullLevel(lv + 1) - x0) * (level % 1) + x0;
    }

    static double getTotalExpToFullLevel(double level) {
        return (HALF_GROWTH * (level - 2) + BASE) * (level - 1);
    }

    static double getPercentageToNextLevel(double exp) {
        double lv = ILeveling.getLevel(exp), x0 = getTotalExpToLevel(lv);
        return (exp - x0) / (ILeveling.getTotalExpToLevel(lv + 1) - x0);
    }
}
