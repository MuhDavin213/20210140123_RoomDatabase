package com.example.roomsiswa.ui.theme.Halaman

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roomsiswa.R
import com.example.roomsiswa.model.DetailSiswa
import com.example.roomsiswa.model.EntryViewModel
import com.example.roomsiswa.model.PenyediaViewModel
import com.example.roomsiswa.model.UIStateSiswa
import com.example.roomsiswa.navigasi.DestinasiNavigasi
import com.example.roomsiswa.navigasi.SiswaTopAppBar
import kotlinx.coroutines.launch

object  DestinasiEntry: DestinasiNavigasi{
    override val route = "item_entry"
    override val titleRes = R.string.entry_siswa
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntrySiswaScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
){    val coroutineScope = rememberCoroutineScope()
    val scroolBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = modifier.nestedScroll(scroolBehavior.nestedScrollConnection),
        topBar = {
            SiswaTopAppBar(
                title = stringResource(DestinasiEntry.titleRes),
                canNavigateBack = true,
                scrollBehavior = scroolBehavior
            )
        }) {innerPadding ->
        EntrySiswaBody(
            uiStateSiswa = viewModel.uiStateSiswa,
            onSiswaValueChange = viewModel::updateUIState,
            onSaveClick = {
                coroutineScope.launch{
                    viewModel.saveSiswa()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()

        )
    }
}

@Composable
fun EntrySiswaBody(uiStateSiswa: UIStateSiswa,
                   onSiswaValueChange: (DetailSiswa) -> Unit,
                   onSaveClick: () -> Unit,
                   modifier: Modifier) {

}
