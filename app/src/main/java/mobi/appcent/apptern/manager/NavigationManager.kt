package mobi.appcent.apptern.manager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import mobi.appcent.apptern.R
import mobi.appcent.apptern.ui.home.HomeFragment

class NavigationManager {
    private fun replaceFragment(
        fragment: Fragment,
        layoutID: Int?,
        fragmentManager: FragmentManager,
        tag: String?,
        isAddToBackStack: Boolean
    ) {
        if (isAddToBackStack) {
            fragment.let { fragment ->
                layoutID?.let { layoutID ->
                    fragmentManager.beginTransaction().replace(layoutID, fragment, tag)
                        .addToBackStack(tag)
                        .commitAllowingStateLoss()
                }
            }
        } else {
            fragment.let { fragment ->
                layoutID?.let { layoutID ->
                    fragmentManager.beginTransaction().replace(layoutID, fragment, tag)
                        .commitAllowingStateLoss()
                }
            }
        }
    }

    fun startHomeFragment(fragmentManager: FragmentManager, isAddToBackStack: Boolean) {
        replaceFragment(
            HomeFragment(),
            R.id.navHostFragment,
            fragmentManager,
            NavigationConstant.HOME_FRAGMET,
            isAddToBackStack
        )
    }
}