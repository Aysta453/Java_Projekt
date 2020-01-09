/*
 * Copyright (c) 2019. Wojciech Wrona
 * All rights reserved
 */

package GUI;

import javafx.scene.control.TableView;
import org.jetbrains.annotations.NotNull;

public interface TableViewInterfaceConnect {
    // Interface that creates Table specific Table View in GUI
    void MarkiTableView(@NotNull TableView tableView);
    void ModeleTableView(@NotNull TableView tableView);
    void PrezesTableView(@NotNull TableView tableView);
    void Dane_modeluTableView(@NotNull TableView tableView);
}
